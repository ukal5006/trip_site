package com.example.trip.brewery.dto;

public class BreweryDTO {
	private int breweryNum;
	private String breweryTitle;
	private String breweryAddress;
	private String breweryKind;
	private String breweryTel;
	private int minPeople;
	private String breweryImg;
	private double brewery_lat;
	private double brewery_long;
	
	public BreweryDTO() {}
	
	
	public BreweryDTO(String breweryTitle, String breweryAddress, String breweryKind, String breweryTel, int minPeople,
			String breweryImg) {
		this.breweryTitle = breweryTitle;
		this.breweryAddress = breweryAddress;
		this.breweryKind = breweryKind;
		this.breweryTel = breweryTel;
		this.minPeople = minPeople;
		this.breweryImg = breweryImg;
	}


	public BreweryDTO(int breweryNum, String breweryTitle, String breweryAddress, String breweryKind, String breweryTel,
			int minPeople, String breweryImg, double brewery_lat, double brewery_long) {
		
		this.breweryNum = breweryNum;
		this.breweryTitle = breweryTitle;
		this.breweryAddress = breweryAddress;
		this.breweryKind = breweryKind;
		this.breweryTel = breweryTel;
		this.minPeople = minPeople;
		this.breweryImg = breweryImg;
		this.brewery_lat = brewery_lat;
		this.brewery_long = brewery_long;
	}

	public int getBreweryNum() {
		return breweryNum;
	}

	public void setBreweryNum(int breweryNum) {
		this.breweryNum = breweryNum;
	}

	public String getBreweryTitle() {
		return breweryTitle;
	}

	public void setBreweryTitle(String breweryTitle) {
		this.breweryTitle = breweryTitle;
	}

	public String getBreweryAddress() {
		return breweryAddress;
	}

	public void setBreweryAddress(String breweryAddress) {
		this.breweryAddress = breweryAddress;
	}

	public String getBreweryKind() {
		return breweryKind;
	}

	public void setBreweryKind(String breweryKind) {
		this.breweryKind = breweryKind;
	}

	public String getBreweryTel() {
		return breweryTel;
	}

	public void setBreweryTel(String breweryTel) {
		this.breweryTel = breweryTel;
	}

	public int getMinPeople() {
		return minPeople;
	}

	public void setMinPeople(int minPeople) {
		this.minPeople = minPeople;
	}

	public String getBreweryImg() {
		return breweryImg;
	}

	public void setBreweryImg(String breweryImg) {
		this.breweryImg = breweryImg;
	}

	public double getBrewery_lat() {
		return brewery_lat;
	}

	public void setBrewery_lat(double brewery_lat) {
		this.brewery_lat = brewery_lat;
	}

	public double getBrewery_long() {
		return brewery_long;
	}

	public void setBrewery_long(double brewery_long) {
		this.brewery_long = brewery_long;
	}
}
