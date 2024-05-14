package com.example.trip.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.board.dao.NoticeDAO;
import com.example.trip.board.dto.NoticeDTO;
import com.example.trip.util.AdminOnly;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO ndao;
	// 공지사항 목록 가져오기
	public List<NoticeDTO> getList() {
		return ndao.getList();
	}

	// 공지사항 글 1개 가져오기
	public NoticeDTO showContent(int noticeId) {
		return ndao.showContent(noticeId);
	}

	// 공지사항 쓰기
	@AdminOnly
    public int writeNotice(NoticeDTO notice) {
        return ndao.writeNotice(notice);
    }
	//공지사항 수정하기
	@AdminOnly
    public boolean updateNotice(NoticeDTO notice) {
        return ndao.updateNotice(notice) > 0;
    }
	
	//공지사항 삭제하기
	@AdminOnly
	public void deleteNotice(int noticeId) {
		ndao.deleteNotice(noticeId);
	}

}
