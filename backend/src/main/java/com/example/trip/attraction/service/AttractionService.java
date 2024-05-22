package com.example.trip.attraction.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.attraction.dao.attractionDAO;
import com.example.trip.attraction.dto.AttractionInfoDTO;
import com.example.trip.board.dao.ReviewDAO;

@Service
public class AttractionService {
	@Autowired
	private attractionDAO adao;
	//관광지 1개 조회
    public List<Map<String, Object>> selectList(int cidtype){
    	return adao.selectList(cidtype);
    }
	//관광지 랜덤 3개 가져오기
    public List<AttractionInfoDTO> getRandomAttractions(String region) {
        return adao.getRandomAttractions(region);
    }
    
    //범위내 관광지 가져오기
    public List<Map<String, Object>> getInRangeAttractions(double latitude, double longitude, int level) {
        double radius = convertLevelToRadius(level);
        return adao.getInRangeAttractions(latitude, longitude, radius);
    }
    
    // 카카오 맵 레벨 받아서 거리로 바꾸기
    private double convertLevelToRadius(int level) {
        switch (level) {
            case 1: return 0.05;  // 50m
            case 2: return 0.1;   // 100m
            case 3: return 0.2;   // 200m
            case 4: return 0.4;   // 400m
            case 5: return 0.8;   // 800m
            case 6: return 1.6;   // 1.6km
            case 7: return 3.2;   // 3.2km
            case 8: return 6.4;   // 6.4km
            default: return 1.0;  // 기본값 1km
        }
    }
    //랜덤 맛집 3개 
    public List<Map<String, Object>> getRandomRestaurant(String region){
    	return adao.getRandomRestaurant(region);
    }
    //조회순 top 3 보내주기
    public List<Map<String, Object>> getTop3(String region){
    	return adao.getTop3(region);
    }
}