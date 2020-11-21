package com.chauhan.quiz.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chauhan.quiz.entity.Subject;
import com.chauhan.quiz.entity.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
	
	public List<Topic> findBySubject(Subject subject);
}
