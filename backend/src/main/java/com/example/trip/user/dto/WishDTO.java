package com.example.trip.user.dto;

public class WishDTO {
	private int wishId;
	private int contentId;
	private String userId;

	public WishDTO() {
		super();
	}

	public WishDTO(String userId) {
		super();
		this.userId = userId;
	}

	public WishDTO(int contentId, String userId) {
		super();
		this.contentId = contentId;
		this.userId = userId;
	}

	public WishDTO(int wishId, int contentId, String userId) {
		super();
		this.wishId = wishId;
		this.contentId = contentId;
		this.userId = userId;
	}

	public int getWishId() {
		return wishId;
	}

	public void setWishId(int wishId) {
		this.wishId = wishId;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "WishDTO [wishId=" + wishId + ", contentId=" + contentId + ", userId=" + userId + "]";
	}

}
