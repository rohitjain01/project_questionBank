/**
 * 
 */
package com.metacube.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author Rohit
 *
 */
@Entity
@Table(name="answers")
@Data
public class Answer {
	@Id
	@Column(name="answer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)// for auto number
	private int answerId;
	
	@Column(name="description", length=1000)
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="question_id")
	private Question questionId;
	
	@Column(name="isverify")
	private boolean verifyAnswer;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
	private User userId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="posted_time")
	private Date postedTime;
	
	public Answer() {
	}

	/**
	 * @param id
	 * @param description
	 * @param questionId
	 * @param verifyAnswer
	 * @param userId
	 * @param postedTime
	 */
	public Answer(int id, String description, Question questionId, boolean verifyAnswer,
			User userId, Date postedTime) {
		super();
		this.answerId = id;
		this.description = description;
		this.questionId = questionId;
		this.verifyAnswer = verifyAnswer;
		this.userId = userId;
		this.postedTime = postedTime;
	}	
}
