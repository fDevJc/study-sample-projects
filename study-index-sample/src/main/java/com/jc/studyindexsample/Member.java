package com.jc.studyindexsample;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String location;
	private String job;

	public Member(String name, String location, String job) {
		this.name = name;
		this.location = location;
		this.job = job;
	}
}
