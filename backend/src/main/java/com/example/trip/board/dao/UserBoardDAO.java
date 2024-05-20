package com.example.trip.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.trip.board.dto.UserBoardDTO;

@Mapper
public interface UserBoardDAO {

	public List<UserBoardDTO> getList();

	public UserBoardDTO showContent(int boardId);

	public int writeBoard(UserBoardDTO board);

	public int updateBoard(UserBoardDTO board);

	public int incrementViewCount(int boardId);

	public void incrementGood(int postId);

	public void incrementBad(int postId);

	public int deleteBoard(int boardId);
}
