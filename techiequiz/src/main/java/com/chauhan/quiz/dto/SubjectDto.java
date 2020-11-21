package com.chauhan.quiz.dto;

import java.util.ArrayList;
import java.util.List;

import com.chauhan.quiz.entity.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SubjectDto {
	private int subId;
	private String subName;
	private String subDesc;
	
	private List<Topic> topics;
	
	public SubjectDto() {}
	
	public SubjectDto(int subId, String subName, String subDesc, List<Topic> topics) {
		super();
		this.subId = subId;
		this.subName = subName;
		this.subDesc = subDesc;
		this.topics = new ArrayList<>(topics);
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
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	
	
}
