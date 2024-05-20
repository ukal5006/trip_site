package com.example.trip.brewery.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BreweryDAO {
	
	// 양조장 전체 리스트 보여주기
	public List<Map<String, Object>> showBreweryList();
	
	//해당 지역 양조장 리스트 보여주기
	public List<Map<String, Object>> showBreweryRegionList(String region);
}
