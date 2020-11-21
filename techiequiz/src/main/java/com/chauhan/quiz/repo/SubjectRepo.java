package com.chauhan.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chauhan.quiz.entity.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Integer>{
	
}
