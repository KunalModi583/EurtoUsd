package com.example.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponceCurrency {
	
	private String code;
	private String alphaCode;
	private Integer numericCode;
	private String name;
	private Double rate;
	private Date date;
	private Double inverseRate;

}
