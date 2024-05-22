package com.example.trip.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trip.board.dto.ReviewLikeDTO;
import com.example.trip.board.service.ReviewLikeService;

@RestController
@RequestMapping("/review/like")
public class ReviewLikeController {
	@Autowired
	private ReviewLikeService reviewLikeService;

	@PostMapping
	public ResponseEntity<?> likeOrDislikeReview(@RequestBody ReviewLikeDTO likeDTO) {
		try {
			reviewLikeService.likeOrDislikeReview(likeDTO);
			return ResponseEntity.ok("Success");
		}
		catch (Exception e) {
			return ResponseEntity.status(500).body("Failed to like/dislike the review.");
		}
	}

	@GetMapping("/{reviewId}/likes")
	public ResponseEntity<Integer> countLikes(@PathVariable int reviewId) {
		int count = reviewLikeService.countLikes(reviewId);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/{reviewId}/dislikes")
	public ResponseEntity<Integer> countDislikes(@PathVariable int reviewId) {
		int count = reviewLikeService.countDislikes(reviewId);
		return ResponseEntity.ok(count);
	}
}
