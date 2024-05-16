package com.example.trip.brewery.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "양조장 컨트롤러", description="" )
@RequestMapping(value = "/brewery")
public class BreweryController {
	
}