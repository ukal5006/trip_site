package com.example.trip.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.trip.board.dto.CommentDTO;
import com.example.trip.board.dto.ReviewDTO;

@Mapper
public interface ReviewDAO {

	public List<ReviewDTO> getList(int contentId);

	public List<ReviewDTO> getListOrderGood(int contentId);

	public int writeReview(ReviewDTO review);

	public int updateReview(ReviewDTO review);

	public void incrementGood(int reviewId);

	public void incrementBad(int reviewId);

	public void decrementGood(int reviewId);

	public void decrementBad(int reviewId);

	public int deleteReview(ReviewDTO review);

	public int isUser(ReviewDTO review);
}