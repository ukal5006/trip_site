package com.example.trip.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.board.dao.ReviewDAO;
import com.example.trip.board.dto.ReviewDTO;
import com.example.trip.board.dto.ReviewLikeDTO;
import com.example.trip.board.dto.UserBoardLikeDTO;

@Service
public class ReviewService {
	@Autowired
	private ReviewDAO rdao;
	@Autowired
	private ReviewLikeService rservice;

	public List<ReviewDTO> getList(int contentId) {
		return rdao.getList(contentId);
	}

	public List<ReviewDTO> getListOrderGood(int contentId) {
		return rdao.getListOrderGood(contentId);
	}

	public int writeReview(ReviewDTO review) {
		return rdao.writeReview(review);
	}

	public int updateReview(ReviewDTO review) {
		return rdao.updateReview(review);
	}

	public int deleteReview(int reviewId) {
		return rdao.deleteReview(reviewId);
	}

	public boolean likeReview(int reviewId, String userId, int good) {
		ReviewLikeDTO tmp = new ReviewLikeDTO(reviewId, userId, good);
		return rservice.likeOrDislikeReview(tmp);
	}
}
