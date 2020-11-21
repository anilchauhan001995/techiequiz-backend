package com.chauhan.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chauhan.message.CustomErrorCodes;
import com.chauhan.quiz.dto.SubjectDto;
import com.chauhan.quiz.dto.TopicDto;
import com.chauhan.quiz.entity.Subject;
import com.chauhan.quiz.entity.Topic;
import com.chauhan.quiz.exception.MobileException;
import com.chauhan.quiz.exception.ResourceNotFoundException;
import com.chauhan.quiz.handler.BaseHandler;
import com.chauhan.quiz.repo.SubjectRepo;
import com.chauhan.quiz.repo.TopicRepository;
import com.chauhan.quiz.request.BaseRequest;
import com.chauhan.quiz.response.SubjectResponse;

@Service
public class AdminService extends BaseHandler<RequestEntity<BaseRequest>, ResponseEntity<SubjectResponse>> {
	
	@Autowired
	private SubjectRepo subjectRepo;
	@Autowired
	private TopicRepository topicRepo;
	
	public ResponseEntity<SubjectResponse> getAllSubjects() throws MobileException, Exception {
		SubjectResponse response = new SubjectResponse();
		List<Subject> subjects = subjectRepo.findAll();
		if (subjects == null) {
			throw new MobileException(CustomErrorCodes.M0003);
		}
		if (subjects.size() > 0) {
			response.setSubjects(subjects);
			return ResponseEntity.ok(response);
		}
		throw new MobileException(CustomErrorCodes.M0002);
		
	}
	
	public SubjectDto getSubjectWithTopic(int subId) {
		Subject subject = subjectRepo.findById(subId)
				.orElseThrow( () -> new ResourceNotFoundException("Subject Resource Not Found"));
		List<Topic> topics = topicRepo.findBySubject(subject);
		SubjectDto subDto = new SubjectDto(subject.getSubId(), subject.getSubName(), subject.getSubDesc(), topics);
		return subDto;
	}
	
	public Subject addSubject(Subject subject) {
		return subjectRepo.save(subject);
	}
	
	public Subject deleteSubject(int subId) {
		return subjectRepo.findById(subId).map(obj -> {
			subjectRepo.delete(obj);
			return obj;
		}).orElseThrow(() -> new ResourceNotFoundException("Subject TResource Not FOund"));
	}
	
	public Subject updateSubject(SubjectDto sub) {
		return subjectRepo.findById(sub.getSubId()).map(obj -> {
			obj.setSubName(sub.getSubName());
			obj.setSubDesc(sub.getSubDesc());
			return subjectRepo.save(obj);
		}).orElseThrow(() -> new ResourceNotFoundException("Subject TResource Not FOund"));
	}
	
	public Topic addTopic(TopicDto dto) {
		System.out.println("AddTopic");
		return subjectRepo.findById(dto.getSubId())
				.map(object -> {
					System.out.println("Subject Found");
					Topic topic = new Topic(dto.gettName(), dto.gettDesc(), object);
					return topicRepo.save(topic);
				})
				.orElseThrow(() -> new ResourceNotFoundException("Subject Resource Not Found"));
	}
	
	public List<Topic> getAllTopic() {
		return topicRepo.findAll();
	}
	
	public List<Topic> getTopicBySubject(int subId) {
		return null;
	}
	
	protected ResponseEntity<SubjectResponse> handle(RequestEntity<BaseRequest> request) throws MobileException, Exception {
		return this.getAllSubjects();
	}

	@Override
	protected ResponseEntity<SubjectResponse> createErrorResposne() {
		return new ResponseEntity<SubjectResponse>(new SubjectResponse(), HttpStatus.BAD_REQUEST);
	}

}
