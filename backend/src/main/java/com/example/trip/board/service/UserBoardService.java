package com.example.trip.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.board.dao.UserBoardDAO;
import com.example.trip.board.dto.UserBoardDTO;

@Service
public class UserBoardService {
	@Autowired
	private UserBoardDAO udao;

	public List<UserBoardDTO> getList() {
		return udao.getList();
	}

	public UserBoardDTO showContent(int boardId) {
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

}
