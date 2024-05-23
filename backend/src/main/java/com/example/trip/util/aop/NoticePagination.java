package com.example.trip.util.aop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trip.board.dao.NoticeDAO;

@Component
public class NoticePagination {

	@Autowired
	private final NoticeDAO noticeDAO;
	private static final int PAGE_SIZE = 10;

//	@Autowired
	public NoticePagination(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public Map<String, Object> getPageInfo(int page) {
		Map<String, Object> pageInfo = new HashMap<>();

		// 전체 게시물 수 조회
		int totalCount = noticeDAO.selectTotalCount();

		// 총 페이지 수 계산
		int totalPages = (int) Math.ceil((double) totalCount / PAGE_SIZE);

		// 요청한 페이지 번호가 범위를 벗어나면 마지막 페이지로 설정
		if (page > totalPages) {
			page = totalPages;
		}
		if (page < 1) {
			page = 1;
		}

		int offset = (page - 1) * PAGE_SIZE;

		// 페이지 정보 설정
		int startPage = (page - 1) / PAGE_SIZE * PAGE_SIZE + 1;
		int endPage = startPage + 9;
		if (endPage > totalPages) {
			endPage = totalPages;
		}

		pageInfo.put("startPage", startPage);
		pageInfo.put("endPage", endPage);
		pageInfo.put("totalPages", totalPages);
		pageInfo.put("offset", offset);
		pageInfo.put("pageSize", PAGE_SIZE);
		pageInfo.put("curPage", page);

		return pageInfo;
	}
}