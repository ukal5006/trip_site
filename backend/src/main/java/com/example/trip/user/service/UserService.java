package com.example.trip.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.trip.user.dao.UserDAO;
import com.example.trip.user.dto.LoginDTO;
import com.example.trip.user.dto.UserDTO;

@Service
public class UserService {
	@Autowired
	private UserDAO udao;
	@Autowired
	private JavaMailSender jms;

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

	public boolean isAdmin(String userId) {
		if (udao.isAdmin(userId) == 1) {
			return true;
		}
		else {
			return false;
		}
	}

	public void sendEmail(String to, String tmpPw) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("qqa109@naver.com");
		message.setTo(to);
		message.setSubject("비밀번호 초기화");
		message.setText("비밀번호 초기화가 완료되었습니다. 초기화된 비밀번호는 : (" + tmpPw + ") 입니다.");
		jms.send(message);
	}
}
