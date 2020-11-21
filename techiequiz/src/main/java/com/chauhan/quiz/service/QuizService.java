package com.chauhan.quiz.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chauhan.quiz.entity.Subject;
import com.chauhan.quiz.repo.SubjectRepo;

@Service
public class QuizService {
	
	@Autowired
	private SubjectRepo subjectRepo;
	public List<Subject> getAllSubjects() { 
		return subjectRepo.findAll();
	}
}
