package com.example.trip.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.board.dao.CommentDAO;
import com.example.trip.board.dto.CommentDTO;

@Service
public class CommentService {

	@Autowired
	private CommentDAO cdao;

	public List<CommentDTO> getList(int postId) {
		return cdao.getList(postId);
	}

	public int writeComment(CommentDTO comment) {
		return cdao.writeComment(comment);
	}

	public int updateComment(CommentDTO comment) {
		return cdao.updateComment(comment);
	}

	public int deleteComment(int commentId) {
		return cdao.deleteComment(commentId);
	}
}
