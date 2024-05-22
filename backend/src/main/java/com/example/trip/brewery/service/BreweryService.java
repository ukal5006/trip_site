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
    	switch(region) {
    	case"충청":
    		return bdao.showBreweryRegionList(List.of("충남", "충북"));
    	case"전라":
    		return bdao.showBreweryRegionList(List.of("전북", "전남"));
    	case"경상":
    		return bdao.showBreweryRegionList(List.of("경북", "경남"));
    	}
    	return bdao.showBreweryRegionList(List.of(region));
    }
}
