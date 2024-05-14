package com.example.trip.attraction.dto;

public class AttractionDescriptionDTO {
	private int contentId;
	private String overview;

	public AttractionDescriptionDTO() {
	}

	public AttractionDescriptionDTO(int contentId, String overview) {
		this.contentId = contentId;
		this.overview = overview;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	@Override
	public String toString() {
		return "AttractionDescriptionDTO [contentId=" + contentId + ", overview=" + overview + "]";
	}

}
