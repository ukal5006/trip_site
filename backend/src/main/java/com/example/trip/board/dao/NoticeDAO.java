package com.example.trip.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.trip.board.dto.NoticeDTO;

@Mapper
public interface NoticeDAO {

	public List<NoticeDTO> getList(); // 공지사항 목록 전체 가져오기

	public List<NoticeDTO> getListOrderDate(); // 공지사항 최근5개 가져오기

	public NoticeDTO showContent(int noticeId); // ID를 직접 받아 처리

	public int writeNotice(NoticeDTO notice); // 공지사항 글 쓰기

	public int updateNotice(NoticeDTO notice); // 공지사항 수정하기

	public int incrementViewCount(int noticeId);

	public List<NoticeDTO> getNoticeList(@Param("limit") int limit, @Param("offset") int offset); // 페이징 처리된 공지사항 목록
																									// 가져오기

	public int selectTotalCount(); // 전체 공지사항 수 조회

	public int deleteNotice(NoticeDTO notice); // 공지사항 삭제하기
}