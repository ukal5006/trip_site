package com.example.trip.board.dto;

public class UserBoardLikeDTO {

	private int likeId;
	private int postId;
	private String userId;
	private boolean isGood;

	public UserBoardLikeDTO() {
		super();
	}

	public UserBoardLikeDTO(int postId, String userId, boolean isGood) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.isGood = isGood;
	}

	public UserBoardLikeDTO(int likeId, int postId, String userId, boolean isGood) {
		super();
		this.likeId = likeId;
		this.postId = postId;
		this.userId = userId;
		this.isGood = isGood;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
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

	public boolean isGood() {
		return isGood;
	}

	public void setGood(boolean isGood) {
		this.isGood = isGood;
	}

	@Override
	public String toString() {
		return "UserBoardLikeDTO [likeId=" + likeId + ", postId=" + postId + ", userId=" + userId + ", isGood=" + isGood
				+ "]";
	}

}
