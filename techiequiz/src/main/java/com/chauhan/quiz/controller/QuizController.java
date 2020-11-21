package com.chauhan.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chauhan.quiz.entity.Subject;
import com.chauhan.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "http://localhost:555")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@GetMapping("/subjects")
	public List<Subject> getAllSubjects() {
		return quizService.getAllSubjects();
	}
}
