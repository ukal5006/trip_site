package com.example.trip.board.dto;

public class PageDTO {
	private int limit;
	private int offset;

	public PageDTO() {
		super();
	}

	public PageDTO(int limit, int offset) {
		super();
		this.limit = limit;
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public String toString() {
		return "PageDTO [limit=" + limit + ", offset=" + offset + "]";
	}

}