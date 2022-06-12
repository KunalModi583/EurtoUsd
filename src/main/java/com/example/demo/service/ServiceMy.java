package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.Client;

@Service
public class ServiceMy {

	@Autowired
	private Client client;

	public Double getDevRate() {
		return client.getRate("usd");
	}

	public String hello() {
		return "Hello";
	}

	public Double getDevRateProd() {
		return client.getRateProd("usd");
	}

	public String getTimeAndDate() {
		Date date = new Date();
		String pattern = "yyyy-MM-dd'T'hh:mm+ss'Z'";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getTimeZone("IST"));
		String dateText = sdf.format(date);
		return dateText;
	}

}
