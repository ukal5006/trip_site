package com.example.trip.attraction.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.trip.attraction.dto.AttractionInfoDTO;

@Mapper
public interface attractionDAO {
	// 관광지 1개 가져오기
	public List<Map<String, Object>> selectList(int cidtype);
	public List<AttractionInfoDTO> getRandomAttractions(String region); //관광지 랜덤 3개 가져오기
	//범위내 관광지 조회
	public List<Map<String, Object>> getInRangeAttractions(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("radius") double radius);
	// 음식집 랜덤 3개 가져오기
	public List<Map<String, Object>> getRandomRestaurant(String region);
	//조회순 top3 보여주기
	public List<Map<String, Object>> getTop3(String region);
}
