package com.example.trip.festival.dto;

public class FestivalDTO {
	private String titie;
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


	public FestivalDTO(String titie, String imgUrl, String startDate, String endDate, String address, String money,
			String institution, String telNum, String homePage) {
		super();
		this.titie = titie;
		this.imgUrl = imgUrl;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.money = money;
		this.institution = institution;
		this.telNum = telNum;
		this.homePage = homePage;
	}


	public String getTitie() {
		return titie;
	}


	public void setTitie(String titie) {
		this.titie = titie;
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
