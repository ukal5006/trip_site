package com.example.trip.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trip.user.dto.LoginResponseDTO;
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
	public ResponseEntity<?> login(@RequestParam String userId, @RequestParam String userPwd) {
		UserDTO loginInfo = uservice.login(userId, userPwd);
		if (loginInfo != null) { // 로그인 성공
			String accessToken = jwtUtil.createAccessToken(userId);
			String refreshToken = jwtUtil.createRefreshToken(userId);

			LoginResponseDTO response = new LoginResponseDTO(loginInfo, accessToken, refreshToken);
			return ResponseEntity.ok().body(response);
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
	
	// 토큰 재 발급
//	@PostMapping(value = "/refresh", headers = {"Content-type=application/json"})
//	public ResponseEntity<?> refresh(@RequestBody String refreshToken) {
//	    String newAccessToken = jwtUtil.refreshAccessToken(refreshToken);
//	    if (newAccessToken != null) {
//	        return ResponseEntity.ok().body(newAccessToken);
//	    } else {
//	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token.");
//	    }
//	}
}
