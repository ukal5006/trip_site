package com.example.trip.board.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.trip.board.dto.UserBoardLikeDTO;

@Mapper
public interface UserBoardLikeDAO {
	public int insertLike(UserBoardLikeDTO like);

	public int updateLike(UserBoardLikeDTO like);

	public UserBoardLikeDTO getLike(int boardId, String userId);

	public int countLikes(int boardId);

	public int countDislikes(int boardId);
}
