package com.example.trip.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trip.board.dto.CommentDTO;
import com.example.trip.board.service.CommentService;
import com.example.trip.user.service.UserService;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
	@Autowired
	private CommentService cservice;

	// 댓글 목록 조회
	@GetMapping()
	public ResponseEntity<List<CommentDTO>> getList(@RequestParam int postId) {
		try {
			List<CommentDTO> comments = cservice.getList(postId);
			return ResponseEntity.ok(comments);
		}
		catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

	// 댓글 등록
	@PostMapping(value = "/write", headers = {
			"Content-type=application/json" })
	public ResponseEntity<?> writeBoard(@RequestBody CommentDTO comment) {
		try {
			cservice.writeComment(comment);
			return ResponseEntity.status(HttpStatus.CREATED).body("댓글이 성공적으로 등록되었습니다.");
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 등록에 실패했습니다.");
		}
	}

	// 댓글 수정
	@PutMapping("/update")
	public ResponseEntity<?> updateBoard(@RequestBody CommentDTO comment) {
		if (cservice.isUser(comment)) {
			try {
				int status = cservice.updateComment(comment);
				if (status > 0) {
					return ResponseEntity.ok("댓글이 성공적으로 수정되었습니다.");
				}
				else {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("댓글을 찾을 수 없습니다.");
				}
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 수정에 실패했습니다.");
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("권한이 없습니다.");
		}
	}

	// 댓글 삭제
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteBoard(@RequestBody CommentDTO comment) {
		if (cservice.isUser(comment)) {
			try {
				int status = cservice.deleteComment(comment);
				if (status > 0) {
					return ResponseEntity.ok("댓글이 성공적으로 삭제되었습니다.");
				}
				else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 삭제에 실패했습니다.");
				}
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 삭제에 실패했습니다.");
			}

		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("권한이 없습니다.");

		}
	}
}
