package com.example.trip.festival.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FestivalDAO {
	//축제 리스트 보내주기
	public List<Map<String, Object>> showList();

}
