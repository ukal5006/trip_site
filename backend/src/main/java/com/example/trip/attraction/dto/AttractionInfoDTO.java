package com.example.trip.attraction.dto;

public class AttractionInfoDTO {
	private int contendId;
	private int contentTypeId;
	private String title;
	private String addr1;
	private String zipcode;
	private String tel;
	private String firstImage;
	private String firstImage2;
	private int readCount;
	private int sidoCode;
	private int gugunCode;
	private double latitude;
	private double longitude;
	
	
	public AttractionInfoDTO() {
		super();
	}

	
	public AttractionInfoDTO(String title, String addr1, String firstImage) {
		this.title = title;
		this.addr1 = addr1;
		this.firstImage = firstImage;
	}


	public AttractionInfoDTO(int contendId, int contentTypeId, String title, String addr1, String zipcode, String tel,
			String firstImage, String firstImage2, int readCount, int sidoCode, int gugunCode, double latitude,
			double longitude) {
		this.contendId = contendId;
		this.contentTypeId = contentTypeId;
		this.title = title;
		this.addr1 = addr1;
		this.zipcode = zipcode;
		this.tel = tel;
		this.firstImage = firstImage;
		this.firstImage2 = firstImage2;
		this.readCount = readCount;
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public int getContendId() {
		return contendId;
	}


	public void setContendId(int contendId) {
		this.contendId = contendId;
	}


	public int getContentTypeId() {
		return contentTypeId;
	}


	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAddr1() {
		return addr1;
	}


	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getFirstImage() {
		return firstImage;
	}


	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}


	public String getFirstImage2() {
		return firstImage2;
	}


	public void setFirstImage2(String firstImage2) {
		this.firstImage2 = firstImage2;
	}


	public int getReadCount() {
		return readCount;
	}


	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}


	public int getSidoCode() {
		return sidoCode;
	}


	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}


	public int getGugunCode() {
		return gugunCode;
	}


	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
