package com.faq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.faq.entity.Question;
import com.faq.repository.FaqRepository;
@Service
public  class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private FaqRepository faqRepository;

	@Override
	public List<Question> findAll() {
		
		return faqRepository.findAll();
	}

	@Override
	public Question save(Question question) {
	
		return faqRepository.save(question);
	}
	
	
	@Override
	public Optional<Question> getQuestion(Long qId) {
		
		return faqRepository.findById(qId);
	}

	@Override
	public String deleteQuestionById(long qId) {
		
		faqRepository.deleteById(qId);
		return "Successfully Deleted";
	}

	
	@Override
	public List<Question> searchQuestions(String query) {
		List <Question> questions = faqRepository.searchQuestions(query);
		return questions;
	}
   
	
	@Override
	public Page<Question> findQuestionWithPaginationAndSorting(int offset, int pageSize, String field){
		
	Page<Question> questions = faqRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
		
		return questions;
		
			}

	@Override
	public Question updateQuestion(Question question) {
		Optional<Question> isExistingQuestion = faqRepository.findById(question.getqId());
		if(isExistingQuestion.isPresent()) {
			Question existingQuestion = isExistingQuestion.get();
			existingQuestion.setQuestion(question.getQuestion());
		existingQuestion.setQuestionCategory(question.getQuestionCategory());
		existingQuestion.setAnswer(question.getAnswer());
		return faqRepository.save(existingQuestion);
	
	}
		else {
			return null;
		}
	
	} }
