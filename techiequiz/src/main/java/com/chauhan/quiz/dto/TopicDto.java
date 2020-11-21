package com.chauhan.quiz.dto;

import com.chauhan.quiz.entity.Subject;

public class TopicDto {
	private int tid;
	private String tName;
	private String tDesc;
	private int subId;
	
	public TopicDto() {}
	
	public TopicDto(int tid, String tName, String tDesc, int subId) {
		this.tid = tid;
		this.tName = tName;
		this.tDesc = tDesc;
		this.subId = subId;
	}
	public TopicDto(String tName, String tDesc, int subId) {
		this.tName = tName;
		this.tDesc = tDesc;
		this.subId = subId;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettDesc() {
		return tDesc;
	}
	public void settDesc(String tDesc) {
		this.tDesc = tDesc;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}

	@Override
	public String toString() {
		return "TopicDto [tid=" + tid + ", tName=" + tName + ", tDesc=" + tDesc + ", subId=" + subId + "]";
	}
}
