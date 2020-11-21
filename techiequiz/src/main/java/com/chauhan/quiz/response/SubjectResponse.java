package com.chauhan.quiz.response;

import java.util.List;

import com.chauhan.quiz.entity.Subject;

public class SubjectResponse extends BaseResponse {
	
	List<Subject> subjects;

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
}
