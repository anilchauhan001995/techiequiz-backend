package com.chauhan.quiz.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subId;
	private String subName;
	private String subDesc;
	
	public Subject() {}
	
	public Subject(int subId, String subName, String subDesc) {
		super();
		this.subId = subId;
		this.subName = subName;
		this.subDesc = subDesc;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubDesc() {
		return subDesc;
	}
	public void setSubDesc(String subDesc) {
		this.subDesc = subDesc;
	}

	@Override
	public String toString() {
		return "Subject [subId=" + subId + ", subName=" + subName + ", subDesc=" + subDesc + "]";
	}
}
