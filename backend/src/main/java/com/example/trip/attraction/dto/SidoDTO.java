package com.example.trip.attraction.dto;

public class SidoDTO {
	private int sidoCode;
	private String sidoName;
	public SidoDTO(int sidoCode, String sidoName) {
		super();
		this.sidoCode = sidoCode;
		this.sidoName = sidoName;
	}
	public int getSidoCode() {
		return sidoCode;
	}
	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	@Override
	public String toString() {
		return "SidoDTO [sidoCode=" + sidoCode + ", sidoName=" + sidoName + "]";
	}
	

}
