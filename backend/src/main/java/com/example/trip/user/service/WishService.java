package com.example.trip.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.board.dto.UserBoardDTO;
import com.example.trip.user.dao.WishDAO;
import com.example.trip.user.dto.WishDTO;

@Service
public class WishService {
	@Autowired
	private WishDAO wdao;
	@Autowired
	private UserService uservice;

	public List<WishDTO> getList(String userId) {
		return wdao.getList(userId);
	}

	public int insertWish(WishDTO wish) {
		return wdao.insertWish(wish);
	}

	public int deleteWish(WishDTO wish) {
		return wdao.deleteWish(wish);
	}
	public boolean isUser(WishDTO wish) {
		if (wdao.isUser(wish) > 0 || uservice.isAdmin(wish.getUserId())) {
			return true;
		}
		else {
			return false;
		}
	}
}
