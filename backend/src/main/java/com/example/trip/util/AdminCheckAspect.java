package com.example.trip.util;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trip.user.dto.UserDTO;
import com.example.trip.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@Aspect
@Component
//관리자 권한 체크
public class AdminCheckAspect { 
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserService uservice;
	
    @Before("execution(* com.example.trip.board.service.NoticeService.*Notice(..)) && args(noticeId,..)")
    public void checkAdminPrivilege(int noticeId) {
        String userId = (String) session.getAttribute("userId");
        UserDTO user = uservice.findById(userId);
        if (user == null || user.getAdmin() != 1) {
            throw new SecurityException("관리자 권한이 필요합니다.");
        }
    }
}