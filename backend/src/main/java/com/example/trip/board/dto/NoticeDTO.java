package com.example.trip.board.dto;

import java.util.Date;

public class NoticeDTO {
	private int noticeId;
	private Date writeDate;
	private String content;
	private String noticeImg;
	private String userId; // 작성자 아이디
	private String noticeTitle;
	private int readCount;

	public NoticeDTO() {
		super();
	}

	public NoticeDTO(int noticeId) {
		super();
		this.noticeId = noticeId;
	}

	public NoticeDTO(int noticeId, String userId) {
		super();
		this.noticeId = noticeId;
		this.userId = userId;
	}

	public NoticeDTO(String content, String userId, String noticeTitle) {
		super();
		this.content = content;
		this.userId = userId;
		this.noticeTitle = noticeTitle;
	}

	public NoticeDTO(int noticeId, String content, String noticeImg, String noticeTitle) {
		super();
		this.noticeId = noticeId;
		this.content = content;
		this.noticeImg = noticeImg;
		this.noticeTitle = noticeTitle;
	}

	public NoticeDTO(Date writeDate, String userId, String noticeTitle, int readCount) {
		super();
		this.writeDate = writeDate;
		this.userId = userId;
		this.noticeTitle = noticeTitle;
		this.readCount = readCount;
	}

	public NoticeDTO(int noticeId, Date writeDate, String content, String noticeImg, String userId, String noticeTitle,
			int readCount) {
		super();
		this.noticeId = noticeId;
		this.writeDate = writeDate;
		this.content = content;
		this.noticeImg = noticeImg;
		this.userId = userId;
		this.noticeTitle = noticeTitle;
		this.readCount = readCount;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNoticeImg() {
		return noticeImg;
	}

	public void setNoticeImg(String noticeImg) {
		this.noticeImg = noticeImg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "NoticeDTO [noticeId=" + noticeId + ", writeDate=" + writeDate + ", content=" + content + ", noticeImg="
				+ noticeImg + ", noticeTitle=" + noticeTitle + ", userId=" + userId + ", readCount=" + readCount + "]";
	}

}
