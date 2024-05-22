package com.example.trip.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.board.dao.ReviewDAO;
import com.example.trip.board.dto.CommentDTO;
import com.example.trip.board.dto.ReviewDTO;
import com.example.trip.board.dto.ReviewLikeDTO;
import com.example.trip.board.dto.UserBoardLikeDTO;
import com.example.trip.user.service.UserService;

@Service
public class ReviewService {
	@Autowired
	private ReviewDAO rdao;
	@Autowired
	private ReviewLikeService rservice;
	@Autowired
	private UserService uservice;

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

	public int deleteReview(ReviewDTO review) {
		return rdao.deleteReview(review);
	}

	public boolean likeReview(int reviewId, String userId, int good) {
		ReviewLikeDTO tmp = new ReviewLikeDTO(reviewId, userId, good);
		return rservice.likeOrDislikeReview(tmp);
	}

	public boolean isUser(ReviewDTO review) {
		if (rdao.isUser(review) > 0 || uservice.isAdmin(review.getUserId())) {
			return true;
		}
		else {
			return false;
		}
	}
}
