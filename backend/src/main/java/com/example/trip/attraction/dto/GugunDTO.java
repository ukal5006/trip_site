package com.example.trip.attraction.dto;

public class GugunDTO {
	private int gugunCode;
	private String gugunName;
	private int sidiCode;
	public GugunDTO(int gugunCode, String gugunName, int sidiCode) {
		super();
		this.gugunCode = gugunCode;
		this.gugunName = gugunName;
		this.sidiCode = sidiCode;
	}
	public int getGugunCode() {
		return gugunCode;
	}
	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}
	public String getGugunName() {
		return gugunName;
	}
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	public int getSidiCode() {
		return sidiCode;
	}
	public void setSidiCode(int sidiCode) {
		this.sidiCode = sidiCode;
	}
	@Override
	public String toString() {
		return "GugunDTO [gugunCode=" + gugunCode + ", gugunName=" + gugunName + ", sidiCode=" + sidiCode + "]";
	}
	
	
}
