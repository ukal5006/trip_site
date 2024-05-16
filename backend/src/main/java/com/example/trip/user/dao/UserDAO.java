package com.example.trip.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.trip.user.dto.UserDTO;

@Mapper
public interface UserDAO {

	public UserDTO login(UserDTO user); // 로그인

//	public UserDTO login(String Id, String Pw);
//	public UserDTO login(@Param("userId") String userId, @Param("userPwd") String userPwd);

	public UserDTO findById(String userId);

	public void insertUser(UserDTO user);
	public void deleteUser(String userId);

}
