package com.example.trip.board.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.trip.board.dto.ReviewLikeDTO;

@Mapper
public interface ReviewLikeDAO {
	public int insertLike(ReviewLikeDTO like);

	public int updateLike(ReviewLikeDTO like);

	public ReviewLikeDTO getLike(int reviewId, String userId);

	public int countLikes(int reviewId);

	public int countDislikes(int reviewId);

}
