package com.example.trip.board.dto;

import java.util.Date;

public class CommentDTO {
	private int commentId;
	private int postId;
	private String userId;
	private String comment;
	private Date writeDate;
	private Date updateDate;

	public CommentDTO() {
		super();
	}

	public CommentDTO(String userId) {
		super();
		this.userId = userId;
	}

	public CommentDTO(int commentId, String comment) {
		super();
		this.commentId = commentId;
		this.comment = comment;
	}

	public CommentDTO(int commentId, int postId, String comment) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.comment = comment;
	}

	public CommentDTO(int commentId, String comment, Date updateDate) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.updateDate = updateDate;
	}

	public CommentDTO(int postId, String userId, String comment) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.comment = comment;
	}

	public CommentDTO(int commentId, int postId, String userId, String comment, Date writeDate, Date updateDate) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.userId = userId;
		this.comment = comment;
		this.writeDate = writeDate;
		this.updateDate = updateDate;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "CommentDTO [commentId=" + commentId + ", postId=" + postId + ", userId=" + userId + ", comment="
				+ comment + ", writeDate=" + writeDate + ", updateDate=" + updateDate + "]";
	}

}
