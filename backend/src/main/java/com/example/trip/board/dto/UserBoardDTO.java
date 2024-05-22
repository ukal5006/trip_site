package com.example.trip.board.dto;

import java.util.Date;

public class UserBoardDTO {
	private int postId;
	private int postType;
	private String title;
	private String content;
	private Date writeDate;
	private Date updateDate;
	private String userId;
	private int readCount;
	private int good;
	private int bad;

	public UserBoardDTO() {
		super();
	}

	public UserBoardDTO(int postId) {
		super();
		this.postId = postId;
	}

	public UserBoardDTO(int postId, String userId) {
		super();
		this.postId = postId;
		this.userId = userId;
	}

	public UserBoardDTO(int postId, String title, String content) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
	}

	public UserBoardDTO(int postType, String title, String content, String userId) {
		super();
		this.postType = postType;
		this.title = title;
		this.content = content;
		this.userId = userId;
	}

	public UserBoardDTO(int postType, String title, Date writeDate, String userId, int readCount, int good, int bad) {
		super();
		this.postType = postType;
		this.title = title;
		this.writeDate = writeDate;
		this.userId = userId;
		this.readCount = readCount;
		this.good = good;
		this.bad = bad;
	}

	public UserBoardDTO(int postId, int postType, String title, String content, Date writeDate, Date updateDate,
			String userId, int readCount, int good, int bad) {
		super();
		this.postId = postId;
		this.postType = postType;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.updateDate = updateDate;
		this.userId = userId;
		this.readCount = readCount;
		this.good = good;
		this.bad = bad;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getPostType() {
		return postType;
	}

	public void setPostType(int postType) {
		this.postType = postType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
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

	@Override
	public String toString() {
		return "UserBoardDTO [postId=" + postId + ", postType=" + postType + ", title=" + title + ", content=" + content
				+ ", writeDate=" + writeDate + ", updateDate=" + updateDate + ", userId=" + userId + ", readCount="
				+ readCount + ", good=" + good + ", bad=" + bad + "]";
	}

}
