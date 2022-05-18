package com.bookworm.user.model;

import org.springframework.stereotype.Component;

@Component
public class ApiResponse {
	
	private String message;
	private String error;
	private String status;
	private Integer id;
	private Integer userType;
	
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", error=" + error + ", status=" + status + ", id=" + id
				+ ", userType=" + userType + "]";
	}
	
}
