package com.faq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.faq.entity.Question;

@Repository
public interface FaqRepository extends JpaRepository<Question,Long>{
    
	@Query("SELECT q FROM Question q WHERE " + 
	"q.question LIKE CONCAT('%',:query,'%')" +
			"Or q.questionCategory LIKE CONCAT('%',:query,'%')")
	List<Question> searchQuestions(String query) ;
	
	
	
}
