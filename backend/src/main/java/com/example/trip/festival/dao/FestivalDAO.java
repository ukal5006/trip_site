package com.example.trip.festival.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FestivalDAO {
    //축제 리스트 보내주기
    public List<Map<String, Object>> showList();
    // 범위 내 축제 리스트 보내주기
    public List<Map<String,Object>> rangeList(@Param("startIdx") int startIdx, @Param("endIdx") int endIdx);
    // 축제 리스트 하나 전달
    public List<Map<String, Object>> showDetail(int no);

}
