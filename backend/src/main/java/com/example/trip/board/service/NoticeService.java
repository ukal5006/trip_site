package com.example.trip.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.board.dao.NoticeDAO;
import com.example.trip.board.dto.NoticeDTO;
import com.example.trip.board.dto.ReviewDTO;
import com.example.trip.user.service.UserService;
import com.example.trip.util.AdminOnly;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO ndao;
	@Autowired
	private UserService uservice;

	// 공지사항 목록 가져오기
	public List<NoticeDTO> getList() {
		return ndao.getList();
	}

	public List<NoticeDTO> getListOrderDate() {
		return ndao.getListOrderDate();
	}

	// 공지사항 글 1개 가져오기
	public NoticeDTO showContent(int noticeId) {
		ndao.incrementViewCount(noticeId);
		return ndao.showContent(noticeId);
	}

	// 공지사항 쓰기
//	@AdminOnly
	public int writeNotice(NoticeDTO notice) {
		return ndao.writeNotice(notice);
	}

	// 공지사항 수정하기
//	@AdminOnly
	public int updateNotice(NoticeDTO notice) {
		return ndao.updateNotice(notice);
	}

	// 공지사항 삭제하기
//	@AdminOnly
	public int deleteNotice(NoticeDTO notice) {
		return ndao.deleteNotice(notice);
	}
	public boolean isUser(NoticeDTO notice) {
		if (uservice.isAdmin(notice.getUserId())) {
			return true;
		}
		else {
			return false;
		}
	}

}

//@Service
//public class NoticeService {
//
//    @Autowired
//    private NoticeRepository noticeRepository;
//
//    public void writeNotice(NoticeDTO notice) {
//        noticeRepository.save(notice);
//    }
//
//    public void updateNotice(NoticeDTO notice) {
//        noticeRepository.save(notice);
//    }
//
//    public NoticeDTO getNotice(int noticeId) {
//        return noticeRepository.findById(noticeId).orElse(null);
//    }
//
//    // 기타 공지사항 관련 메서드들
//}