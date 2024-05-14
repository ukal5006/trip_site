package com.example.trip.attraction.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.trip.attraction.dto.AttractionInfoDTO;

@Mapper
public interface attractionDAO {
	public List<AttractionInfoDTO> selectList(int cidtype); // 관광지 1개 가져오기
	public List<AttractionInfoDTO> getRandomAttractions(); //관광지 랜덤 3개 가져오기
	
	
}
