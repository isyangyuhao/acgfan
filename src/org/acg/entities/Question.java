package org.acg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

/**
 * 问题实体类
 * @author yangyuhao
 */
@Table(name="QUESTION")
@Entity
public class Question {

	private Integer id;
	private String content;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private String answerRight;
	
	public Question() {
		
	}
	
	@Column(name="ID")
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="CONTENT")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="ANSWER_A")
	public String getAnswerA() {
		return answerA;
	}
	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}
	
	@Column(name="ANSWER_B")
	public String getAnswerB() {
		return answerB;
	}
	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}
	
	@Column(name="ANSWER_C")
	public String getAnswerC() {
		return answerC;
	}
	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}
	
	@Column(name="ANSWER_D")
	public String getAnswerD() {
		return answerD;
	}
	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}
	
	@Column(name="ANSWER_RIGHT")
	public String getAnswerRight() {
		return answerRight;
	}
	public void setAnswerRight(String answerRight) {
		this.answerRight = answerRight;
	}
	
}
