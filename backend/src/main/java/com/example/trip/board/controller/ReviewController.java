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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.trip.board.dto.NoticeDTO;
import com.example.trip.board.service.NoticeService;
import com.example.trip.brewery.service.BreweryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@Tag(name = "리뷰 컨트롤러", description="리뷰 CRUD" )
@RequestMapping(value = "/review")
public class ReviewController {
    @Autowired
    private BreweryService bservice;
    
//    //리뷰 리스트 가져오기
//    @GetMapping("/contentList")
//    @Operation(method ="GET", summary="공지사항 전체 가져오기")
//    public List<NoticeDTO> getList(){
//    	return bservice.getList();
//    }

//    //커뮤니티 게시글 자세히 보기
//    @GetMapping("/showContent")
//    public NoticeDTO showNotice(@RequestParam("noticeId") int noticeId) {
//    	 NoticeDTO n = bservice.showContent(noticeId);
//    	 System.out.println(n.toString());
//    	return bservice.showContent(noticeId);
//    }
    
//    //공지사항 게시글 작성하기(공지사항은 관리자만 작성할 수 있음)
//    @PostMapping("/write")
//    public ResponseEntity<?> writeNotice(@RequestBody NoticeDTO notice, HttpSession session) {
//        String userId = (String) session.getAttribute("userId");  // 세션에서 사용자 ID 가져오기
//        notice.setUserId(userId);  // NoticeDTO에 사용자 ID 설정
//
//        int noticeId = bservice.writeNotice(notice);  // 공지사항 작성
//        if (noticeId > 0) {
//            notice.setNoticeId(noticeId);  // 새로 생성된 공지사항 ID 설정
//            return ResponseEntity.ok(notice);
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("공지사항 작성 실패");
//        }
//    }
    
//    //공지시항 게시글 수정(공지사항은 관리자만 수정할 수 있음)
//    @PutMapping("/update")
//    public ResponseEntity<?> updateNotice(@RequestBody NoticeDTO notice) {
//        try {
//            boolean updated = bservice.updateNotice(notice);
//            if (!updated) {
//                return ResponseEntity.badRequest().body("Update failed or no permission.");
//            }
//            return ResponseEntity.ok("Notice updated successfully.");
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body("An error occurred: " + e.getMessage());
//        }
//    }
    
//    // 공지사항 삭제 메소드
//    @DeleteMapping("/delete/{noticeId}")
//    public ResponseEntity<?> deleteNotice(@PathVariable int noticeId) {
//        try {
//        	bservice.deleteNotice(noticeId);
//            return ResponseEntity.ok("Notice deleted successfully.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete notice: " + e.getMessage());
//        }
//    }
}