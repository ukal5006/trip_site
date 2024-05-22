package com.example.trip.board.dto;

import java.util.Date;

public class ReviewDTO {
	private int reviewId;
	private int contentId;
	private String userId;
	private int rate;
	private String content;
	private int good;
	private int bad;
	private Date writeDate;
	private Date updateDate;

	public ReviewDTO() {
	}

	public ReviewDTO(int reviewId, String userId) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
	}

	public ReviewDTO(int rate, String content, Date updateDate) {
		this.rate = rate;
		this.content = content;
		this.updateDate = updateDate;
	}

	public ReviewDTO(int reviewId, int rate, String content) {
		super();
		this.reviewId = reviewId;
		this.rate = rate;
		this.content = content;
	}

	public ReviewDTO(int contentId, String userId, int rate, String content) {
		this.contentId = contentId;
		this.userId = userId;
		this.rate = rate;
		this.content = content;
	}

	public ReviewDTO(int reviewId, int contentId, String userId, int rate, String content, int good, int bad,
			Date writeDate, Date updateDate) {
		this.reviewId = reviewId;
		this.contentId = contentId;
		this.userId = userId;
		this.rate = rate;
		this.content = content;
		this.good = good;
		this.bad = bad;
		this.writeDate = writeDate;
		this.updateDate = updateDate;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
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

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getBad() {
		return bad;
	}

	public void setBad(int bad) {
		this.bad = bad;
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
		return "ReviewDTO [reviewId=" + reviewId + ", contentId=" + contentId + ", userId=" + userId + ", rate=" + rate
				+ ", content=" + content + ", good=" + good + ", bad=" + bad + ", writeDate=" + writeDate
				+ ", updateDate=" + updateDate + "]";
	}

}
