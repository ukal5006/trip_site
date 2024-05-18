package com.example.trip.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.trip.board.dto.ReviewDTO;

@Mapper
public interface ReviewDAO {

	public List<ReviewDTO> getList();

	public ReviewDTO showContent(int reviewId);

	public int writeReview(ReviewDTO review);

	public int updateReview(ReviewDTO review);

	public int deleteReview(int reviewId);
}