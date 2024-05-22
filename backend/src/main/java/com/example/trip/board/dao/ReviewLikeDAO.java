package com.example.trip.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.trip.board.dto.ReviewLikeDTO;
import com.example.trip.board.dto.UserBoardLikeDTO;

@Mapper
public interface ReviewLikeDAO {
	public int insertLike(ReviewLikeDTO like);

	public int updateLike(ReviewLikeDTO like);

	public int deleteLike(ReviewLikeDTO like);

	public int find(@Param("reviewId") int reviewId, @Param("userId") String userId);

	public int getLike(@Param("reviewId") int reviewId, @Param("userId") String userId);

	public int countLikes(int reviewId);

	public int countDislikes(int reviewId);

}
