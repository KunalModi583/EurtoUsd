package com.example.demo.client;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ResponceCurrency;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Client {

	@Resource
	private ObjectMapper objectMapper;

	private Double eurToUsdExchange = 1.113;

	private Map<String, ResponceCurrency> obj;

	public void getNewCurrencyData() {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = "http://www.floatrates.com/daily/EUR.json";
		// Fetch JSON response as String wrapped in ResponseEntity
		ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
		try {
			obj = objectMapper.readValue(response.getBody(), new TypeReference<Map<String, ResponceCurrency>>() {});
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Double getRate(String key) {
		key = key.toLowerCase();
		return eurToUsdExchange;
	}

	public Double getRateProd(String key) {
		key = key.toLowerCase();
		getNewCurrencyData();
		return this.obj.get(key).getRate();
	}

}
