package com.example.trip.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.board.dao.UserBoardDAO;
import com.example.trip.board.dto.ReviewLikeDTO;
import com.example.trip.board.dto.UserBoardDTO;
import com.example.trip.board.dto.UserBoardLikeDTO;

@Service
public class UserBoardService {
	@Autowired
	private UserBoardDAO udao;
	@Autowired
	private UserBoardLikeService uservice;

	public List<UserBoardDTO> getList() {
		return udao.getList();
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

	public int deleteBoard(int boardId) {
		return udao.deleteBoard(boardId);
	}

	public void likeBoard(int boardId, String userId) {
		UserBoardLikeDTO like = new UserBoardLikeDTO(boardId, userId, true);
		uservice.likeOrDislikePost(like);
		udao.incrementGood(boardId);
	}

	public void dislikeBoard(int boardId, String userId) {
		UserBoardLikeDTO dislike = new UserBoardLikeDTO(boardId, userId, false);
		uservice.likeOrDislikePost(dislike);
		udao.incrementBad(boardId);
	}

}
