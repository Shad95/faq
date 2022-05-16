package com.faq.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faq.entity.Question;
import com.faq.service.QuestionService;

@RestController
@RequestMapping("/faq")
public class QuestionController {
    @Autowired
	private QuestionService questionService;
    
    // get the list of all questions
    
    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
    	
    	return new ResponseEntity<List<Question>>(questionService.findAll(),HttpStatus.OK);
    	
    }
    
    //get a single question by id
    
    @GetMapping("/questions/{qId}") 
    public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable("qId") Long qId){
     return new ResponseEntity<Optional<Question>>(questionService.getQuestion(qId),HttpStatus.OK);
    }
    
    // create a new question
    
    @PostMapping("/questions")
    public  ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
    	return new ResponseEntity<Question>(questionService.save(question),HttpStatus.CREATED);
    }
    
    
 // replace a question
    
    @PutMapping("/questions") 
    public  ResponseEntity<Question> replaceQuestion(@RequestBody Question question) {
    	return new ResponseEntity<Question>(questionService.updateQuestion(question),HttpStatus.CREATED);
    	
    }
    
    
    // delete a question by id
    
    @DeleteMapping("/questions/{qId}") 
    	public ResponseEntity<String> deleteQuestion(@PathVariable("qId") Long qId) {
    	return new ResponseEntity<String>(questionService.deleteQuestionById(qId),HttpStatus.OK);
    }
    
    
    //search a question
    
    @GetMapping("questions/search")
    public ResponseEntity<List<Question>> searchQuestions(@RequestParam("query") String query) {
    	
    	return new ResponseEntity<List<Question>> (questionService.searchQuestions(query),HttpStatus.OK);
    }
    
    
    // pagination and sorting implementation
    @GetMapping("/questions/pagination/{offset}/{pageSize}/{field}")
    public ResponseEntity<Page<Question>> getQuestionsWithPaginationAndSort(@PathVariable int offset,@PathVariable int pageSize ,@PathVariable  String field) {
    	
    	Page<Question> questionsWithPagination = questionService.findQuestionWithPaginationAndSorting(offset, pageSize, field);
       
    	return new ResponseEntity<Page<Question>>(questionsWithPagination,HttpStatus.OK);
    }
    
    
    
}
