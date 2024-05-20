package com.example.trip.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.trip.board.dto.UserBoardLikeDTO;

@Mapper
public interface UserBoardLikeDAO {
	public int insertLike(UserBoardLikeDTO like);

	public int updateLike(UserBoardLikeDTO like);

	public int deleteLike(UserBoardLikeDTO like);
	
	public int find(@Param("postId")int postId, @Param("userId") String userId );

	public int getLike(@Param("postId")int postId, @Param("userId") String userId );

	public int countLikes(int boardId);

	public int countDislikes(int boardId);

}
