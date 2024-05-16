package com.example.trip.attraction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.attraction.dao.attractionDAO;
import com.example.trip.attraction.dto.AttractionInfoDTO;

@Service
public class AttractionService {
	@Autowired
	private attractionDAO adao;
	//관광지 1개 조회
	public List<AttractionInfoDTO> selectList(int cidtype) {
		return adao.selectList(cidtype);
	}
	//관광지 랜덤 3개 가져오기
    public List<AttractionInfoDTO> getRandomAttractions(String region) {
        return adao.getRandomAttractions(region);
    }
	
}