package com.example.trip.board.dto;

public class ReviewDTO {
	private int reviewId;
	private String writeDate;
	private String content;
	private String reviewImg;
	private String reviewTitle;
	private String userId; //작성자 아이디
	private String writeName; // 작성자 이름
	private int participate; // 참여 명수
	private int readCount;
	
	
	public ReviewDTO() {}


	public ReviewDTO(int reviewId, String writeDate, String content, String reviewImg, String reviewTitle,
			String userId, String writeName, int participate, int readCount) {
		super();
		this.reviewId = reviewId;
		this.writeDate = writeDate;
		this.content = content;
		this.reviewImg = reviewImg;
		this.reviewTitle = reviewTitle;
		this.userId = userId;
		this.writeName = writeName;
		this.participate = participate;
		this.readCount = readCount;
	}


	public int getReviewId() {
		return reviewId;
	}


	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}


	public String getWriteDate() {
		return writeDate;
	}


	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getReviewImg() {
		return reviewImg;
	}


	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}


	public String getReviewTitle() {
		return reviewTitle;
	}


	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getWriteName() {
		return writeName;
	}


	public void setWriteName(String writeName) {
		this.writeName = writeName;
	}


	public int getParticipate() {
		return participate;
	}


	public void setParticipate(int participate) {
		this.participate = participate;
	}


	public int getReadCount() {
		return readCount;
	}


	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
}
