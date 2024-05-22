package com.example.trip.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.trip.user.dto.LoginDTO;
import com.example.trip.user.dto.UserDTO;

@Mapper
public interface UserDAO {

	public LoginDTO login(LoginDTO login); // 로그인

	public UserDTO getUser(String userId); // 회원정보조회

	public int updateUser(UserDTO user); // 회원정보수정

	public void insertUser(UserDTO user); // 회원가입

	public void deleteUser(String userId); // 회원탈퇴

	public int checkId(String userId); // 중복체크

	public String findId(UserDTO user); // 아이디 찾기

	public String findPw(UserDTO user); // 비밀번호 찾기

	public void initPw(UserDTO user); // 임시 비밀번호 발급
	
	public int isAdmin(String userID);
}
