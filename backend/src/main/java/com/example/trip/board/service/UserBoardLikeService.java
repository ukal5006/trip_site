package com.example.trip.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.trip.board.dao.UserBoardLikeDAO;
import com.example.trip.board.dto.UserBoardLikeDTO;

@Service
public class UserBoardLikeService {
	@Autowired
	private UserBoardLikeDAO userBoardLikeDAO;

	@Transactional
	public void likeOrDislikePost(UserBoardLikeDTO likeDTO) {
		UserBoardLikeDTO existingLike = userBoardLikeDAO.getLike(likeDTO.getPostId(), likeDTO.getUserId());
		if (existingLike == null) {
			userBoardLikeDAO.insertLike(likeDTO);
		}
		else {
			userBoardLikeDAO.updateLike(likeDTO);
		}
	}

	public int countLikes(int postId) {
		return userBoardLikeDAO.countLikes(postId);
	}

	public int countDislikes(int postId) {
		return userBoardLikeDAO.countDislikes(postId);
	}
}
