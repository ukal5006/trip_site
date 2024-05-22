package com.example.trip.festival.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trip.festival.service.festivalService;

@RestController
@RequestMapping("/festival")
public class FestivalController {
	@Autowired
	private festivalService fservice;
	
	//축제 리스트 전체 보내주기
	@GetMapping("/festivalList")
	public ResponseEntity<List<Map<String, Object>>> showList(){
		List<Map<String, Object>> festList = fservice.showList();
		if (festList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(festList);
	}
}
