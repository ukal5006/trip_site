package com.example.trip.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trip.board.dto.UserBoardLikeDTO;
import com.example.trip.board.service.UserBoardLikeService;

@RestController
@RequestMapping("/userBoard/like")
public class UserBoardLikeController {
	@Autowired
	private UserBoardLikeService userBoardLikeService;

	@PostMapping
	public ResponseEntity<?> likeOrDislikePost(@RequestBody UserBoardLikeDTO likeDTO) {
		try {
			userBoardLikeService.likeOrDislikePost(likeDTO);
			return ResponseEntity.ok("Success");
		}
		catch (Exception e) {
			return ResponseEntity.status(500).body("Failed to like/dislike the post.");
		}
	}

	@GetMapping("/{postId}/likes")
	public ResponseEntity<Integer> countLikes(@PathVariable int postId) {
		int count = userBoardLikeService.countLikes(postId);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/{postId}/dislikes")
	public ResponseEntity<Integer> countDislikes(@PathVariable int postId) {
		int count = userBoardLikeService.countDislikes(postId);
		return ResponseEntity.ok(count);
	}
}
