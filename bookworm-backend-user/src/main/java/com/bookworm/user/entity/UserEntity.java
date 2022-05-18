package com.bookworm.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.bookworm.user.model.User;

@Entity
@Table(name = "users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer userId;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column
	private String fullname;
	
	@Column
	private String password;
	
	@Column
	private String occupation;
	
	@Column(name="professional_domain")
	private String professionalDomain;
	
	private Long contact;
	
	private String address;
	
	@Column(name = "user_type")
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
		return "UserEntity [userId=" + userId + ", emailId=" + emailId + ", fullname=" + fullname + ", password="
				+ password + ", occupation=" + occupation + ", professionalDomain=" + professionalDomain + ", contact="
				+ contact + ", address=" + address + ", userType=" + userType + "]";
	}
	
	public User convertToModel() {
		User model = new User();
		model.setUserId(userId);
		model.setEmailId(emailId);
		model.setFullname(fullname);
		model.setPassword(password);
		model.setAddress(address);
		model.setContact(contact);
		model.setOccupation(occupation);
		model.setProfessionalDomain(professionalDomain);
		model.setUserType(userType);
		return model;
	}

}
