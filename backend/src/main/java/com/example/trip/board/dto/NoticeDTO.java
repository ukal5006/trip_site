package com.example.trip.board.dto;

public class NoticeDTO {
	private int noticeId;
	private String writeDate;
	private String content;
	private String noticeImg;
	private String noticeTitle;
	private String userId; //작성자 아이디
	private String writeName; // 작성자 이름
	private int readCount;


	public NoticeDTO() {
	}

	public NoticeDTO(int noticeId) {
		this.noticeId = noticeId;
	}

	public NoticeDTO(int noticeId, String writeDate, String noticeTitle, String writeName, int readCount) {
		this.noticeId = noticeId;
		this.writeDate = writeDate;
		this.noticeTitle = noticeTitle;
		this.writeName = writeName;
		this.readCount = readCount;
	}

	public NoticeDTO(int noticeId, String writeDate, String content, String noticeImg, String noticeTitle,
			String userId, String writeName, int readCount) {
		this.noticeId = noticeId;
		this.writeDate = writeDate;
		this.content = content;
		this.noticeImg = noticeImg;
		this.noticeTitle = noticeTitle;
		this.userId = userId;
		this.writeName = writeName;
		this.readCount = readCount;
	}
	
	@Override
	public String toString() {
		return "NoticeDTO [noticeId=" + noticeId + ", writeDate=" + writeDate + ", content=" + content + ", noticeImg="
				+ noticeImg + ", noticeTitle=" + noticeTitle + ", userId=" + userId + ", writeName=" + writeName
				+ ", readCount=" + readCount + "]";
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
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

	public String getNoticeImg() {
		return noticeImg;
	}

	public void setNoticeImg(String noticeImg) {
		this.noticeImg = noticeImg;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
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

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

}
