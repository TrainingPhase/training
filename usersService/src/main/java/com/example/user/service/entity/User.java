package com.example.user.service.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="micro_users")
@Getter
@Setter
public class User {
	@Id
	@Column(name="ID")
	private String userId;
	@Column(name="NAME")
	private String name;
	@Column(name="EMAIL")
	private String email;
	@Column(name="ABOUT")
	private String about;
	//won't store in database
	@Transient
	private List<Rating> ratings;
	
}
