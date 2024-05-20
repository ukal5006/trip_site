package com.example.trip.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.trip.board.dao.ReviewDAO;
import com.example.trip.board.dao.ReviewLikeDAO;
import com.example.trip.board.dto.ReviewLikeDTO;
import com.example.trip.board.dto.UserBoardLikeDTO;

@Service
public class ReviewLikeService {
	@Autowired
	private ReviewLikeDAO reviewLikeDAO;
	@Autowired
	private ReviewDAO rdao;
	
	public boolean likeOrDislikeReview(ReviewLikeDTO likeDTO) {
		int reviewId = likeDTO.getReviewId();
		int exist = reviewLikeDAO.find(likeDTO.getReviewId(), likeDTO.getUserId());

		try {
			if (exist == 0) {
				reviewLikeDAO.insertLike(new ReviewLikeDTO(likeDTO.getReviewId(), likeDTO.getUserId(), 0));
			}
			int existingLike = reviewLikeDAO.getLike(likeDTO.getReviewId(), likeDTO.getUserId());
			
			if (likeDTO.getisGood() == 1) {
				if (existingLike == 0) { // 좋아요 등록
					rdao.incrementGood(reviewId);
					likeDTO.setisGood(1);
					reviewLikeDAO.updateLike(likeDTO);
				}
				else if (existingLike == -1) { // 좋아요로 변경
					rdao.decrementBad(reviewId);
					rdao.incrementGood(reviewId);
					likeDTO.setisGood(-1);
					reviewLikeDAO.updateLike(likeDTO);
				}
				else { // 좋아요 취소
					rdao.decrementGood(reviewId);
					likeDTO.setisGood(0);
					reviewLikeDAO.deleteLike(likeDTO);
				}
			}
			else if (likeDTO.getisGood() == -1) {
				if (existingLike == 0) { // 싫어요 등록
					reviewLikeDAO.insertLike(likeDTO);
					rdao.incrementBad(reviewId);
				}
				else if (existingLike == 1) { // 싫어요로 변경
					reviewLikeDAO.updateLike(likeDTO);
					rdao.decrementGood(reviewId);
					rdao.incrementBad(reviewId);
				}
				else { // 싫어요 취소
					rdao.decrementBad(reviewId);
					reviewLikeDAO.deleteLike(likeDTO);
				}
			}
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public int countLikes(int postId) {
		return reviewLikeDAO.countLikes(postId);
	}

	public int countDislikes(int postId) {
		return reviewLikeDAO.countDislikes(postId);
	}
}
