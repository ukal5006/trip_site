package com.example.trip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.example.trip.attraction.dao","com.example.trip.board.dao", "com.example.trip.user.dao","com.example.trip.festival.dao","com.example.trip.brewery.dao"})
public class Beans {

}
