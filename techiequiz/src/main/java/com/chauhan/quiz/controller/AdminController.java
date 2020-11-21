package com.chauhan.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.chauhan.quiz.dto.SubjectDto;
import com.chauhan.quiz.dto.TopicDto;
import com.chauhan.quiz.entity.Subject;
import com.chauhan.quiz.entity.Topic;
import com.chauhan.quiz.request.BaseRequest;
import com.chauhan.quiz.response.SubjectResponse;
import com.chauhan.quiz.service.AdminService;

@RequestMapping("/admin")
@RestController
@CrossOrigin(origins = "http://localhost:555")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/subjects")
	public ResponseEntity<SubjectResponse> getAllSubjects(RequestEntity<BaseRequest> request) {
		return adminService.execute(request);
	}
	
	@GetMapping("/subject/{subId}")
	public SubjectDto getSubject(@PathVariable int subId) {
		return adminService.getSubjectWithTopic(subId);
	}
	
	@PostMapping("/subject")
	public Subject addSubject(@RequestBody Subject subject) {
		return adminService.addSubject(subject);
	}
	
	@DeleteMapping("subject/{subId}")
	public ResponseEntity<String> deleteSubject(@PathVariable(name = "subId") int subId) {
		if (adminService.deleteSubject(subId) != null) {
			return ResponseEntity.ok("Deleted SuccessFully");
		}
		return ResponseEntity.badRequest().body("Resource Not Found");
	}
	
	@PutMapping("/subject")
	public ResponseEntity<String> updateSubject(@RequestBody SubjectDto sub) {
		if (adminService.updateSubject(sub) != null) {
			return ResponseEntity.ok("Updated SuccessFully");
		}
		return ResponseEntity.badRequest().body("Resource Not Found");
	}
	
	@PostMapping("/topic")
	public Topic addTopic(@RequestBody TopicDto topicDto) {
		return adminService.addTopic(topicDto);
	}
	
	@GetMapping("/topic")
	public List<Topic> getAllTopics() {
		return adminService.getAllTopic();
	}
	
	@GetMapping("/topic/{subId}")
	public List<Topic> getTopicBySubject(@PathVariable(name = "subId") int subId) {
		return adminService.getTopicBySubject(subId);
	}
}
