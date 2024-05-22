package com.example.trip.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trip.board.dto.CommentDTO;
import com.example.trip.board.dto.ReviewDTO;
import com.example.trip.board.service.ReviewService;
import com.example.trip.util.JWTUtil;

@RestController
@RequestMapping(value = "/review")
public class ReviewController {
	@Autowired
	private ReviewService rservice;

	// 리뷰 목록 조회
	@GetMapping()
	public ResponseEntity<List<ReviewDTO>> getList(@RequestParam int contentId) {
		try {
			List<ReviewDTO> review = rservice.getList(contentId);
			return ResponseEntity.ok(review);
		}
		catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

	@GetMapping("/orderGood")
	public ResponseEntity<List<ReviewDTO>> getListOrderGood(@RequestParam int contentId) {
		try {
			List<ReviewDTO> review = rservice.getListOrderGood(contentId);
			return ResponseEntity.ok(review);
		}
		catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

	// 리뷰 등록
	@PostMapping(value = "/write", headers = {
			"Content-type=application/json" })
	public ResponseEntity<?> writeReview(@RequestBody ReviewDTO review) {
		try {
			rservice.writeReview(review);
			return ResponseEntity.status(HttpStatus.CREATED).body("리뷰가 성공적으로 등록되었습니다.");
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("리뷰 등록에 실패했습니다.");
		}
	}

	// 리뷰 수정
	@PutMapping("/update")
	public ResponseEntity<?> updateReview(@RequestBody ReviewDTO review) {
		if (rservice.isUser(review)) {
			try {
				int status = rservice.updateReview(review);
				if (status > 0) {
					return ResponseEntity.ok("리뷰가 성공적으로 수정되었습니다.");
				}
				else {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("리뷰를 찾을 수 없습니다.");
				}
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("리뷰 수정에 실패했습니다.");
			}

		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("권한이 없습니다.");

		}
	}

	// 리뷰 삭제
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteReview(@RequestBody ReviewDTO review) {
		if (rservice.isUser(review)) {
			try {
				int status = rservice.deleteReview(review);
				if (status > 0) {
					return ResponseEntity.ok("리뷰가 성공적으로 삭제되었습니다.");
				}
				else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("리뷰 삭제에 실패했습니다.");
				}
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("리뷰 삭제에 실패했습니다.");
			}

		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("권한이 없습니다.");

		}
	}

	@PostMapping("/{reviewId}/like")
	public ResponseEntity<String> likeBoard(@PathVariable int reviewId, @RequestHeader("Authorization") String token) {
		JWTUtil tmp = new JWTUtil();
		String userId = tmp.getUserIdFromToken(token);

		if (rservice.likeReview(reviewId, userId, 1)) {
			return ResponseEntity.ok("Review liked successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("좋아요 실패했습니다.");
		}
	}

	@PostMapping("/{reviewId}/dislike")
	public ResponseEntity<String> dislikeBoard(@PathVariable int reviewId,
			@RequestHeader("Authorization") String token) {
		JWTUtil tmp = new JWTUtil();
		String userId = tmp.getUserIdFromToken(token);

		if (rservice.likeReview(reviewId, userId, -1)) {
			return ResponseEntity.ok("Review liked successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("좋아요 실패했습니다.");
		}
	}
}
