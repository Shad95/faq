package com.faq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.faq.entity.Question;

public interface QuestionService {
	
	public List<Question> findAll();
	public Question save(Question question);
	public Optional<Question> getQuestion(Long qId);
	public String deleteQuestionById(long qId);
	List<Question> searchQuestions(String query);
	public Page<Question> findQuestionWithPaginationAndSorting(int offset, int pageSize, String field);
    public Question updateQuestion(Question question);


}
