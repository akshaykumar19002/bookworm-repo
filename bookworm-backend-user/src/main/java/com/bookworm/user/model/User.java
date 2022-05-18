package com.bookworm.user.model;

import org.springframework.stereotype.Component;

import com.bookworm.user.entity.UserEntity;

@Component
public class User {
	
	private Integer userId;
	
	private String emailId;
	
	private String fullname;
	
	private String password;
	
	private String occupation;
	
	private String professionalDomain;
	
	private Long contact;
	
	private String address;
	
	private Integer userType;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getProfessionalDomain() {
		return professionalDomain;
	}

	public void setProfessionalDomain(String professionalDomain) {
		this.professionalDomain = professionalDomain;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", emailId=" + emailId + ", fullname=" + fullname + ", password=" + password
				+ ", occupation=" + occupation + ", professionalDomain=" + professionalDomain + ", contact=" + contact
				+ ", address=" + address + ", userType=" + userType + "]";
	}

	public UserEntity convertToEntity() {
		UserEntity entity = new UserEntity();
		entity.setEmailId(this.emailId);
		entity.setFullname(fullname);
		entity.setPassword(password);
		entity.setAddress(address);
		entity.setContact(contact);
		entity.setOccupation(occupation);
		entity.setProfessionalDomain(professionalDomain);
		entity.setUserType(userType);
		return entity;
	}

}
