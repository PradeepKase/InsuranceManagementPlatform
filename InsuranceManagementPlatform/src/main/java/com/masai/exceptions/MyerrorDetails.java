package com.masai.exceptions;

import java.time.LocalDateTime;

public class MyerrorDetails {
	
	private LocalDateTime timestam;
	private String message;
	private String details;
	
	public LocalDateTime getTimestam() {
		return timestam;
	}
	public void setTimestam(LocalDateTime timestam) {
		this.timestam = timestam;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	

	
	public MyerrorDetails(LocalDateTime timestam, String message, String details) {
		super();
		this.timestam = timestam;
		this.message = message;
		this.details = details;
	}
	public MyerrorDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
}
