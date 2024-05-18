package com.example.trip.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.board.dao.ReviewDAO;
import com.example.trip.board.dto.ReviewDTO;

@Service
public class ReviewService {
	@Autowired
	private ReviewDAO rdao;

	public List<ReviewDTO> getList() {
		return rdao.getList();
	}

	public ReviewDTO showContent(int reviewId) {
		return rdao.showContent(reviewId);
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
}
