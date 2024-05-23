package com.example.trip.festival.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.festival.dao.FestivalDAO;

@Service
public class festivalService {
	@Autowired
	private FestivalDAO fdao;

	// 축제 정보 리스트 보내주기
	public List<Map<String, Object>> showList() {
		return fdao.showList();
	}

	// 축제 범위 값 보내주기
	public List<Map<String, Object>> rangeList(int startIdx, int endIdx) {
		return fdao.rangeList(startIdx, endIdx);
	}

	// 축제 상세보기(하나 값 전달)
	public List<Map<String, Object>> showDetail(int no) {
		return fdao.showDetail(no);
	}
}
