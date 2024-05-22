package com.example.trip.festival.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.festival.dao.FestivalDAO;

@Service
public class festivalService {
	@Autowired
	private FestivalDAO fdao;
	
	//축제 정보 리스트 보내주기
	public List<Map<String, Object>> showList(){
		return fdao.showList();
	}
}
