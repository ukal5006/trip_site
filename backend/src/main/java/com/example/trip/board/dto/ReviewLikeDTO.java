package com.example.trip.board.dto;

public class ReviewLikeDTO {
	private int likeId;
	private int reviewId;
	private String userId;
	private int isGood;

	public ReviewLikeDTO() {
		super();
	}

	public ReviewLikeDTO(int reviewId, String userId) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
	}

	public ReviewLikeDTO(int reviewId, String userId, int isGood) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.isGood = isGood;
	}

	public ReviewLikeDTO(int likeId, int postId, String userId, int isGood) {
		super();
		this.likeId = likeId;
		this.reviewId = postId;
		this.userId = userId;
		this.isGood = isGood;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int postId) {
		this.reviewId = postId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getisGood() {
		return isGood;
	}

	public void setisGood(int isGood) {
		this.isGood = isGood;
	}

	@Override
	public String toString() {
		return "ReviewLikeDTO [likeId=" + likeId + ", reviewId=" + reviewId + ", userId=" + userId + ", isGood="
				+ isGood + "]";
	}

}
