package com.example.trip.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.trip.board.dao.NoticeDAO;
import com.example.trip.board.dto.NoticeDTO;
import com.example.trip.board.dto.ReviewDTO;
import com.example.trip.brewery.dao.BreweryDAO;

public class ReviewController {
	@Autowired
	private BreweryDAO bdao;
	
	// 공지사항 목록 가져오기
//	public List<ReviewDTO> getList() {
//		return bdao.getList();
//	}

//	// 공지사항 글 1개 가져오기
//	public NoticeDTO showContent(int noticeId) {
//		return bdao.showContent(noticeId);
//	}
//
//	// 공지사항 쓰기
//    public int writeNotice(NoticeDTO notice) {
//        return bdao.writeNotice(notice);
//    }
//	//공지사항 수정하기
//    public boolean updateNotice(NoticeDTO notice) {
//        return bdao.updateNotice(notice) > 0;
//    }
//	
//	//공지사항 삭제하기
//	public void deleteNotice(int noticeId) {
//		bdao.deleteNotice(noticeId);
//	}
}
