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

import com.example.trip.board.dto.UserBoardDTO;
import com.example.trip.board.service.UserBoardService;
import com.example.trip.util.JWTUtil;

@RestController
@RequestMapping(value = "/userBoard")
public class UserBoardController {
	@Autowired
	private UserBoardService uservice;

	// 게시글 목록 조회
	@GetMapping()
	public ResponseEntity<List<UserBoardDTO>> getList() {
		try {
			List<UserBoardDTO> posts = uservice.getList();
			return ResponseEntity.ok(posts);
		}
		catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

	@GetMapping("/orderDate")
	public ResponseEntity<List<UserBoardDTO>> getListOrderDate() {
		try {
			List<UserBoardDTO> posts = uservice.getListOrderDate();
			return ResponseEntity.ok(posts);
		}
		catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

	@GetMapping("/orderRead")
	public ResponseEntity<List<UserBoardDTO>> getListOrderRead() {
		try {
			List<UserBoardDTO> posts = uservice.getListOrderRead();
			return ResponseEntity.ok(posts);
		}
		catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

	@GetMapping("/orderGood")
	public ResponseEntity<List<UserBoardDTO>> getListOrderGood() {
		try {
			List<UserBoardDTO> posts = uservice.getListOrderGood();
			return ResponseEntity.ok(posts);
		}
		catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

	// 게시글 세부 조회
	@GetMapping("/{postId}")
	public ResponseEntity<?> showContent(@PathVariable int postId) {
		try {
			UserBoardDTO post = uservice.showContent(postId);
			if (post != null) {
				return ResponseEntity.ok(post);
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("게시글을 찾을 수 없습니다.");
			}
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시글 조회에 실패했습니다.");
		}
	}

	// 게시글 등록
	@PostMapping(value = "/write", headers = {
			"Content-type=application/json" })
	public ResponseEntity<?> writeBoard(@RequestBody UserBoardDTO userBoard) {
		try {
			uservice.writeBoard(userBoard);
			return ResponseEntity.status(HttpStatus.CREATED).body("게시글이 성공적으로 등록되었습니다.");
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시글 등록에 실패했습니다.");
		}
	}

	// 게시글 수정
	@PutMapping("/update")
	public ResponseEntity<?> updateBoard(@RequestBody UserBoardDTO userBoard) {
		if (uservice.isUser(userBoard)) {
			try {
				int status = uservice.updateBoard(userBoard);
				if (status > 0) {
					return ResponseEntity.ok("게시글이 성공적으로 수정되었습니다.");
				}
				else {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("게시글을 찾을 수 없습니다.");
				}
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시글 수정에 실패했습니다.");
			}

		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("권한이 없습니다.");
		}
	}

	// 게시글 삭제
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteBoard(@RequestBody UserBoardDTO userBoard) {
		if (uservice.isUser(userBoard)) {
			try {
				int status = uservice.deleteBoard(userBoard);
				if (status > 0) {
					return ResponseEntity.ok("게시글이 성공적으로 삭제되었습니다.");
				}
				else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시글 삭제에 실패했습니다.");
				}
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시글 삭제에 실패했습니다.");
			}

		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("권한이 없습니다.");
		}
	}

	@PostMapping("/{postId}/like")
	public ResponseEntity<String> likeBoard(@PathVariable int postId, @RequestHeader("Authorization") String token) {
		JWTUtil tmp = new JWTUtil();
		String userId = tmp.getUserIdFromToken(token);

		if (uservice.likeBoard(postId, userId, 1)) {
			return ResponseEntity.ok("Board liked successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("좋아요 실패했습니다.");
		}

	}

	@PostMapping("/{postId}/dislike")
	public ResponseEntity<String> dislikeBoard(@PathVariable int postId, @RequestHeader("Authorization") String token) {
		JWTUtil tmp = new JWTUtil();
		String userId = tmp.getUserIdFromToken(token);

		if (uservice.likeBoard(postId, userId, -1)) {
			return ResponseEntity.ok("Board liked successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("좋아요 실패했습니다.");
		}
	}

}
