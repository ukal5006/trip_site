package com.example.trip.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.trip.user.dto.WishDTO;

@Mapper
public interface WishDAO {
	public List<WishDTO> getList(String userId);

	public int insertWish(WishDTO wish);

	public int deleteWish(WishDTO wish);

	public int isUser(WishDTO wish);

}