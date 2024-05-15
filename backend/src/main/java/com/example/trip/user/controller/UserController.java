package com.example.trip.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trip.user.dto.UserDTO;
import com.example.trip.user.service.UserService;
import com.example.trip.util.JWTUtil;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService uservice;
	@Autowired
	private JWTUtil jwtUtil;
	
	//로그인
	@PostMapping(value = "/login",headers={"Content-type=application/json"})
	public ResponseEntity<?> login(@RequestBody UserDTO user,
			 HttpSession session) {
		UserDTO loginInfo = uservice.login(user.getUserId(), user.getUserPwd());
		
		if(loginInfo!=null) { // 로그인 성공
			String accessToken = jwtUtil.createAccessToken(user.getUserId());
            String refreshToken = jwtUtil.createRefreshToken(user.getUserId());
            
			return ResponseEntity.ok().body(loginInfo);
		}else { // 로그인 실패
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인에 실패하였습니다. 아이디와 패스워드를 확인하세요.");
		}		
	}
	
	//로그아웃
	
}
