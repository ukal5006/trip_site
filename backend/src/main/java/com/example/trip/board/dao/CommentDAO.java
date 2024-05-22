package com.example.trip.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.trip.board.dto.CommentDTO;

@Mapper
public interface CommentDAO {
	public List<CommentDTO> getList(int postId);

	public int writeComment(CommentDTO comment);

	public int updateComment(CommentDTO comment);

	public int deleteComment(CommentDTO comment);

	public int getCount(int postId);

	public int isUser(CommentDTO comment);
}