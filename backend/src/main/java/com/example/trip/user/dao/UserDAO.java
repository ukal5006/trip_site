package com.example.trip.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.trip.user.dto.UserDTO;

@Mapper
public interface UserDAO {

	public UserDTO login(UserDTO user); // 로그인

	public UserDTO findById(String userId);

}
