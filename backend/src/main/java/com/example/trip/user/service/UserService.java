package com.example.trip.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.user.dao.UserDAO;
import com.example.trip.user.dto.UserDTO;

@Service
public class UserService {
	@Autowired
	private UserDAO udao;

	public UserDTO login(String id, String pwd) {
		return udao.login(new UserDTO(id, pwd));
	}

	public UserDTO findById(String userId) {
		return udao.findById(userId);
	}

	public void insertUser(UserDTO user) {
		udao.insertUser(user);
	}

	public void deleteUser(String userId) {
		udao.deleteUser(userId);
	}
}
