package com.example.trip.user.controller;

import java.security.SecureRandom;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trip.user.dto.LoginDTO;
import com.example.trip.user.dto.UserDTO;
import com.example.trip.user.service.UserService;
import com.example.trip.util.JWTUtil;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService uservice;
	@Autowired
	private JWTUtil jwtUtil;

	// 로그인
	@PostMapping(value = "/login", headers = {
			"Content-type=application/json" })
	public ResponseEntity<?> login(@RequestBody LoginDTO login) {
		LoginDTO loginInfo = uservice.login(login);
		if (loginInfo != null) { // 로그인 성공
//			String accessToken = jwtUtil.createAccessToken(login.getUserId());
//			String refreshToken = jwtUtil.createRefreshToken(login.getUserPwd());
//
//			LoginResponseDTO response = new LoginResponseDTO(accessToken, refreshToken);
//			return ResponseEntity.ok().body(response);
			
			UserDTO info = uservice.getUser(login.getUserId());
			return ResponseEntity.ok().body(info);
		}
		else { // 로그인 실패
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인에 실패하였습니다. 아이디와 패스워드를 확인하세요.");
		}
	}

	// 로그아웃
	@PostMapping(value = "/logout", headers = {
			"Content-type=application/json" })
	public ResponseEntity<?> logout(@RequestBody String token) {
		jwtUtil.invalidateToken(token);
		return ResponseEntity.ok().body("로그아웃 되었습니다.");
	}

	// 회원정보조회
	@PostMapping("/getUser")
	public ResponseEntity<?> getUser(@RequestBody LoginDTO user) {
		UserDTO info = uservice.getUser(user.getUserId());
		if (info != null) {
			return ResponseEntity.ok(info);
		}
		else {
			return ResponseEntity.status(404).body("사용자 정보를 찾을 수 없습니다");
		}
	}

	// 회원정보수정
	@PostMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody UserDTO user) {
		try {
			int ststus = uservice.updateUser(user);
			if (ststus != 0) {
				return ResponseEntity.ok("회원정보가 성공적으로 수정되었습니다.");
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자 정보를 찾을 수 없습니다.");
			}
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원정보 수정에 실패했습니다.");
		}
	}

	// 아이디중복체크
	@PostMapping(value = "/idCheck", headers = {
			"Content-type=application/json" })
	public ResponseEntity<?> idCheck(@RequestBody UserDTO user) {
		if (uservice.checkId(user.getUserId()) != 0) { // 아이디 중복체크
			return ResponseEntity.status(HttpStatus.CONFLICT).body("아이디가 이미 존재합니다");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("사용 가능한 아이디입니다.");
	}

	// 회원가입
	@PostMapping(value = "/signup", headers = {
			"Content-type=application/json" })
	public ResponseEntity<?> signup(@RequestBody UserDTO user) {

		if (uservice.checkId(user.getUserId()) != 0) { // 아이디 중복체크
			return ResponseEntity.status(HttpStatus.CONFLICT).body("아이디가 이미 존재합니다");
		}
		if (!isStrongPassword(user.getUserPwd())) { // 비밀번호 강도 확인
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("비밀번호가 강력하지 않습니다.");
		}
		try {
			uservice.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입 실패");
		}
	}

	// 아이디 찾기
	@PostMapping("/findUserId")
	public ResponseEntity<?> findUserId(@RequestBody UserDTO user) {
		String userId = uservice.findId(user);
		if (userId != null) {
			return ResponseEntity.ok("사용자의 아이디는 : " + userId + " 입니다.");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자 정보를 찾을 수 없습니다");
		}
	}

	// 비밀번호 찾기
	@PostMapping("/findUserPw")
	public ResponseEntity<?> findUserPw(@RequestBody UserDTO user) {
		String userPw = uservice.findPw(user);
		if (userPw != null) {
			String tmpPw = getrandomPw(); // 랜덤 비밀번호로 초기화
			user.setUserPwd(tmpPw);
			uservice.initPw(user);
			uservice.sendEmail(user.getUserEmail(), tmpPw);
			return ResponseEntity.ok("사용자의 임시 비밀번호가 메일로 발송되었습니다.");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자 정보를 찾을 수 없습니다");
		}
	}

	// 회원탈퇴
	@DeleteMapping(value = "/delete", headers = {
			"Content-type=application/json" })
	public ResponseEntity<?> deleteUser(@RequestParam String userId) {
		try {
			uservice.deleteUser(userId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("회원탈퇴 성공");
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원탈퇴 실패");
		}
	}

	// 토큰 재 발급
	@PostMapping(value = "/refresh", headers = {
			"Content-type=application/json" })
	public ResponseEntity<?> refresh(@RequestBody String refreshToken) {
		String newAccessToken = jwtUtil.refreshAccessToken(refreshToken);
		if (newAccessToken != null) {
			return ResponseEntity.ok().body(newAccessToken);
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token.");
		}
	}

	// 비밀번호 강도 검사 함수
	public static boolean isStrongPassword(String password) {
		if (password.length() < 8) // 8자 이상
			return false;
		String lowerCasePattern = ".*[a-z].*"; // 소문자 한개 이상 포함
		String digitPattern = ".*[0-9].*"; // 숫자 한개 이상 포함
		String specialCharPattern = ".*[!@#$%^&*()-+=].*"; // 공백 제외 특수문자 한개 이상 포함

		return Pattern.matches(lowerCasePattern, password) && Pattern.matches(digitPattern, password)
				&& Pattern.matches(specialCharPattern, password);
	}

	// 랜덤 비밀번호 생성기
	public static String getrandomPw() {
		String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		int LENGTH = 8;
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(LENGTH);
		for (int i = 0; i < LENGTH; i++) {
			int index = random.nextInt(CHARACTERS.length());
			sb.append(CHARACTERS.charAt(index));
		}
		return sb.toString();
	}
}
