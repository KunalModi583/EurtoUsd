package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.ServiceMy;

@Controller
@RequestMapping(value = "/api")
public class AppController {

	@Autowired
	private ServiceMy ser;

	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok(ser.hello());
	}

	@GetMapping("/get-dev-rate")
	public ResponseEntity<Object> getEurRate() {
		Map<String, Double> rateMap = new HashMap<String, Double>();
		rateMap.put("EUR To USD rate in developer mode", ser.getDevRate());
		return new ResponseEntity<Object>(rateMap, HttpStatus.OK);
	}

	@GetMapping("/get-prod-rate")
	public ResponseEntity<Object> getEurRateProd() {
		Map<String, Double> rateMap = new HashMap<String, Double>();
		rateMap.put("EUR To USD rate in production mode", ser.getDevRateProd());
		return new ResponseEntity<Object>(rateMap, HttpStatus.OK);
	}

	@GetMapping("/get-time-and-date")
	public ResponseEntity<Object> getTimeStamp() {
		Map<String, String> rateMap = new HashMap<String, String>();
		rateMap.put("timestamp", ser.getTimeAndDate());
		return new ResponseEntity<Object>(rateMap, HttpStatus.OK);
	}

	@GetMapping("/get-welcome")
	public String getWelcome() {
		return ("index");
	}
}
