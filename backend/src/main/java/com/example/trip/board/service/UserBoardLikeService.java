package com.example.trip.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.trip.board.dao.UserBoardDAO;
import com.example.trip.board.dao.UserBoardLikeDAO;
import com.example.trip.board.dto.UserBoardLikeDTO;

@Service
public class UserBoardLikeService {
	@Autowired
	private UserBoardLikeDAO userBoardLikeDAO;
	@Autowired
	private UserBoardDAO udao;

	public boolean likeOrDislikePost(UserBoardLikeDTO likeDTO) {
		int postId = likeDTO.getPostId();
		int exist = userBoardLikeDAO.find(likeDTO.getPostId(), likeDTO.getUserId());

		try {
			if (exist == 0) {
				userBoardLikeDAO.insertLike(new UserBoardLikeDTO(likeDTO.getPostId(), likeDTO.getUserId(), 0));
			}
			int existingLike = userBoardLikeDAO.getLike(likeDTO.getPostId(), likeDTO.getUserId());
			
			if (likeDTO.getisGood() == 1) {
				if (existingLike == 0) { // 좋아요 등록
					udao.incrementGood(postId);
					likeDTO.setisGood(1);
					userBoardLikeDAO.updateLike(likeDTO);
				}
				else if (existingLike == -1) { // 좋아요로 변경
					udao.decrementBad(postId);
					udao.incrementGood(postId);
					likeDTO.setisGood(-1);
					userBoardLikeDAO.updateLike(likeDTO);
				}
				else { // 좋아요 취소
					udao.decrementGood(postId);
					likeDTO.setisGood(0);
					userBoardLikeDAO.deleteLike(likeDTO);
				}
			}
			else if (likeDTO.getisGood() == -1) {
				if (existingLike == 0) { // 싫어요 등록
					userBoardLikeDAO.insertLike(likeDTO);
					udao.incrementBad(postId);
				}
				else if (existingLike == 1) { // 싫어요로 변경
					userBoardLikeDAO.updateLike(likeDTO);
					udao.decrementGood(postId);
					udao.incrementBad(postId);
				}
				else { // 싫어요 취소
					udao.decrementBad(postId);
					userBoardLikeDAO.deleteLike(likeDTO);
				}
			}
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public int countLikes(int postId) {
		return userBoardLikeDAO.countLikes(postId);
	}

	public int countDislikes(int postId) {
		return userBoardLikeDAO.countDislikes(postId);
	}

}
