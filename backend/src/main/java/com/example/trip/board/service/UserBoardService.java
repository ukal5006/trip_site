package com.example.trip.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.board.dao.UserBoardDAO;
import com.example.trip.board.dto.UserBoardDTO;
import com.example.trip.board.dto.UserBoardLikeDTO;
import com.example.trip.user.service.UserService;

@Service
public class UserBoardService {
	@Autowired
	private UserBoardDAO udao;
	@Autowired
	private UserBoardLikeService uservice;
	@Autowired
	private UserService uuservice;

	public List<UserBoardDTO> getList() {
		return udao.getList();
	}

	public List<UserBoardDTO> getListOrderDate() {
		return udao.getListOrderDate();
	}

	public List<UserBoardDTO> getListOrderRead() {
		return udao.getListOrderRead();
	}

	public List<UserBoardDTO> getListOrderGood() {
		return udao.getListOrderGood();
	}

	public UserBoardDTO showContent(int boardId) {
		
		udao.incrementViewCount(boardId);
		return udao.showContent(boardId);
	}

	public int writeBoard(UserBoardDTO board) {
		return udao.writeBoard(board);
	}

	public int updateBoard(UserBoardDTO board) {
		return udao.updateBoard(board);
	}

	public int deleteBoard(UserBoardDTO board) {
		return udao.deleteBoard(board);
	}

	public boolean likeBoard(int boardId, String userId, int good) {
		UserBoardLikeDTO tmp = new UserBoardLikeDTO(boardId, userId, good);
		return uservice.likeOrDislikePost(tmp);
	}
	public boolean isUser(UserBoardDTO board) {
		if (udao.isUser(board) > 0 || uuservice.isAdmin(board.getUserId())) {
			return true;
		}
		else {
			return false;
		}
	}
}
