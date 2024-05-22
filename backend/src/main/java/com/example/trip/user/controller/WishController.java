package com.example.trip.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trip.user.dto.WishDTO;
import com.example.trip.user.service.WishService;

@RestController
@RequestMapping(value = "/wishlist")
public class WishController {
	@Autowired
	private WishService wservice;

	// 찜 목록 조회
	@GetMapping("/{userId}")
	public ResponseEntity<List<WishDTO>> getList(@PathVariable String userId) {
		List<WishDTO> wishlist = wservice.getList(userId);
		return ResponseEntity.ok(wishlist);
	}

	// 찜 추가
	@PostMapping("/add")
	public ResponseEntity<?> addWish(@RequestBody WishDTO wish) {
		if (wservice.isUser(wish)) {
			try {
				int status = wservice.insertWish(wish);
				if (status > 0) {
					return ResponseEntity.ok("찜성공");
				}
				else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add wish");
				}
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add wish");
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("권한이 없습니다.");
		}
	}

	// 찜 삭제
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteWish(@RequestBody WishDTO wish) {

		if (wservice.isUser(wish)) {
			try {
				int status = wservice.deleteWish(wish);
				if (status > 0) {
					return ResponseEntity.ok("찜제거");
				}
				else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete wish");
				}
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete wish");
			}

		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("권한이 없습니다.");
		}
	}

}
