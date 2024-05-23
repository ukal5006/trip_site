package com.example.trip.festival.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trip.festival.service.festivalService;

@RestController
@RequestMapping("/festival")
public class FestivalController {
	@Autowired
	private festivalService fservice;

	// 특정 범위의 축제 리스트 보내주기
	@GetMapping("/inRange")
	public ResponseEntity<List<Map<String, Object>>> rangeList(@RequestParam("startIdx") int startIdx,
			@RequestParam("endIdx") int endIdx) {
		List<Map<String, Object>> list = fservice.rangeList(startIdx, endIdx);
		if (list.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(list);
	}

	// 축제 상세보기(하나 값 전달)
	@GetMapping("/showDetail/{no}")
	public ResponseEntity<List<Map<String, Object>>> showDetail(@PathVariable("no") int no) {
		List<Map<String, Object>> detail = fservice.showDetail(no);
		if (detail.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(detail);
	}
}
