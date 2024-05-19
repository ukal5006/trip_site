package com.example.trip.brewery.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trip.brewery.service.BreweryService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "양조장 컨트롤러", description="" )
@RequestMapping(value = "/brewery")
public class BreweryController {
	
	@Autowired
	private BreweryService bservice;
	
	// 전체리스트 보여주기
	@GetMapping("/blist")
	public ResponseEntity<List<Map<String, Object>>> getRandomRestaurant() {
		List<Map<String, Object>> brewInfo = bservice.showBreweryList();
		if (brewInfo.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(brewInfo);
	}
	
	// 양조장 지역별 조회
	@GetMapping("/regionBrewery/{region}")
	public ResponseEntity<List<Map<String, Object>>> showBreweryRegionList(@PathVariable("region") String region) {
		List<Map<String, Object>> brewery = bservice.showBreweryRegionList(region);
		if (brewery.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(brewery);
	}
}