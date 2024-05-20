package com.example.trip.attraction.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trip.attraction.dto.AttractionInfoDTO;
import com.example.trip.attraction.service.AttractionService;

@RestController
@RequestMapping(value = "/attraction")
public class AttractionController {
	@Autowired
	private AttractionService aservice;

	// 원하는 관광지 가져오기(1개)
	@GetMapping("/list/{bbb}")
	public ResponseEntity<?> selectList(@PathVariable("bbb") int cidtype) {
		List<AttractionInfoDTO> attInfo = aservice.selectList(cidtype);
		if (attInfo != null) { // 리스트 가져오기 성공
			return ResponseEntity.ok(attInfo);

		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("리스트에 들어온 값이 없습니다");
		}
	}

	// 관광지 랜덤 3곳 가져오기
	@GetMapping("/randomList/{region}")
	public ResponseEntity<List<AttractionInfoDTO>> getRandomAttractions(@PathVariable("region") String region) {
		List<AttractionInfoDTO> attractions = aservice.getRandomAttractions(region);
		if (attractions.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(attractions);
	}
	
	@GetMapping("/inRange")
	// 관광지 범위 내 조회(지도에 마커 띄우기 용)
	public ResponseEntity<List<Map<String, Object>>> getInRangeAttractions(@RequestParam("latitude") double latitude,
			@RequestParam("longitude") double longitude, @RequestParam("level") int level) {
		List<Map<String, Object>> attractions = aservice.getInRangeAttractions(latitude, longitude, level);
		if (attractions.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(attractions);
	}
	
	// 음식집 랜덤 3곳 가져오기
	@GetMapping("/randomRestaurant/{region}")
	public ResponseEntity<List<Map<String, Object>>> getRandomRestaurant(@PathVariable("region") String region) {
		List<Map<String, Object>> restaurant = aservice.getRandomRestaurant(region);
		if (restaurant.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(restaurant);
	}
	
	//조회순 top3 보여주기
	@GetMapping("/getTop3/{region}")
    public ResponseEntity<List<Map<String, Object>>> getTop3(@PathVariable("region") String region) {
		List<Map<String,Object>> top3 = aservice.getTop3(region);
		if (top3.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(top3);
    }

}
