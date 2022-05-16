package com.faq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faq")
public class Question extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "q_id" ,nullable = false)
	private long qId;	
	
	private String question;	
	
	private String questionCategory;
	
	public String answer;
	
	public Question(long qId, String question, String questionCategory, String answer) {
		super();
		this.qId = qId;
		this.question = question;
		this.questionCategory = questionCategory;
		this.answer = answer;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public long getqId() {
		return qId;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestionCategory() {
		return questionCategory;
	}
	public void setQuestionCategory(String questionCategory) {
		this.questionCategory = questionCategory;
	}
	
}