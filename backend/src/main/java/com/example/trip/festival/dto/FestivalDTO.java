package com.example.trip.festival.dto;

public class FestivalDTO {
	private int festivalNo;
	private String title;
	private String imgUrl;
	private String startDate;
	private String endDate;
	private String address;
	private String money;
	private String institution;
	private String telNum;
	private String homePage;

	public FestivalDTO() {
		super();
	}

	public FestivalDTO(int festivalNo, String title, String imgUrl, String startDate, String endDate, String address,
			String money, String institution, String telNum, String homePage) {
		this.imgUrl = imgUrl;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.money = money;
		this.institution = institution;
		this.telNum = telNum;
		this.homePage = homePage;
	}

	public int getFestivalNo() {
		return festivalNo;
	}

	public void setFestivalNo(int festivalNo) {
		this.festivalNo = festivalNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

}
