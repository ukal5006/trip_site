package com.example.trip.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.trip.board.dto.ReviewDTO;
import com.example.trip.board.dto.UserBoardDTO;

@Mapper
public interface UserBoardDAO {

	public List<UserBoardDTO> getList();

	public List<UserBoardDTO> getListOrderDate();

	public List<UserBoardDTO> getListOrderRead();

	public List<UserBoardDTO> getListOrderGood();

	public UserBoardDTO showContent(int boardId);

	public int writeBoard(UserBoardDTO board);

	public int updateBoard(UserBoardDTO board);

	public int incrementViewCount(int boardId);

	public void incrementGood(int postId);

	public void incrementBad(int postId);

	public void decrementGood(int postId);

	public void decrementBad(int postId);

	public int deleteBoard(UserBoardDTO board);

	public int isUser(UserBoardDTO board);
}
