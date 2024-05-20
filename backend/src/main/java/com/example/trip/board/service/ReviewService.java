package com.example.trip.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.board.dao.ReviewDAO;
import com.example.trip.board.dto.ReviewDTO;
import com.example.trip.board.dto.ReviewLikeDTO;

@Service
public class ReviewService {
	@Autowired
	private ReviewDAO rdao;
	@Autowired
	private ReviewLikeService rservice;

	public List<ReviewDTO> getList(int contentId) {
		return rdao.getList(contentId);
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

	public void likeReview(int reviewId, String userId) {
		ReviewLikeDTO like = new ReviewLikeDTO(reviewId, userId, true);
		rservice.likeOrDislikeReview(like);
		rdao.incrementGood(reviewId);
	}

	public void dislikeReview(int reviewId, String userId) {
		ReviewLikeDTO dislike = new ReviewLikeDTO(reviewId, userId, false);
		rservice.likeOrDislikeReview(dislike);
		rdao.incrementBad(reviewId);
	}
}
