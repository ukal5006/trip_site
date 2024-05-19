package com.example.trip.brewery.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trip.brewery.dao.BreweryDAO;

@Service
public class BreweryService {
	
	@Autowired
	private BreweryDAO bdao;
	//양조장 전체 리스트 넘겨주기
    public List<Map<String, Object>> showBreweryList() {
       return bdao.showBreweryList();
    }
    
    //양조장 해당 지역 리스트 넘겨주기
    public List<Map<String, Object>> showBreweryRegionList(String region){
    	return bdao.showBreweryRegionList(region);
    }
}
