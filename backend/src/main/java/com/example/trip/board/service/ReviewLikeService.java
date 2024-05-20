package com.example.trip.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.trip.board.dao.ReviewLikeDAO;
import com.example.trip.board.dto.ReviewLikeDTO;

@Service
public class ReviewLikeService {
	@Autowired
	private ReviewLikeDAO reviewLikeDAO;

	@Transactional
	public void likeOrDislikeReview(ReviewLikeDTO likeDTO) {
		ReviewLikeDTO existingLike = reviewLikeDAO.getLike(likeDTO.getReviewId(), likeDTO.getUserId());
		if (existingLike == null) {
			reviewLikeDAO.insertLike(likeDTO);
		}
		else {
			reviewLikeDAO.updateLike(likeDTO);
		}
	}

	public int countLikes(int reviewId) {
		return reviewLikeDAO.countLikes(reviewId);
	}

	public int countDislikes(int reviewId) {
		return reviewLikeDAO.countDislikes(reviewId);
	}
}
