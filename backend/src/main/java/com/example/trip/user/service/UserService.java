package com.example.trip.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.user.dao.UserDAO;
import com.example.trip.user.dto.LoginDTO;
import com.example.trip.user.dto.LoginResponseDTO;
import com.example.trip.user.dto.UserDTO;

@Service
public class UserService {
	@Autowired
	private UserDAO udao;

	public LoginDTO login(LoginDTO login) {
		return udao.login(login);
	}

	public UserDTO getUser(String userId) {
		return udao.getUser(userId);
	}
	
	public int updateUser(UserDTO user) {
		return udao.updateUser(user);
	}

	public void insertUser(UserDTO user) {
		udao.insertUser(user);
	}

	public void deleteUser(String userId) {
		udao.deleteUser(userId);
	}

	public int checkId(String userId) {
		return udao.checkId(userId);
	}

	public String findId(UserDTO user) {
		return udao.findId(user);
	}

	public String findPw(UserDTO user) {
		return udao.findPw(user);
	}

	public void initPw(UserDTO user) {
		udao.initPw(user);
	}
}
