/** Model Answer class to store the answers posted by users on different questions
 * 
 */
package com.metacube.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Team MJ
 *
 */

@Entity
@Table(name = "answers")
@Data
public class Answer {

	@Id
	@Column(name = "answer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	// for auto number
	private int answerId;

	@Column(name = "description", length = 1000)
	private String description;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id")
	private Question questionId;

	@Column(name = "isverify")
	private boolean verifyAnswer;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User userId;

	@Temporal(TemporalType.DATE)
	@Column(name = "posted_time")
	private Date postedTime;

	/**
	 * Default constructor
	 */
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
	public Answer(int id, String description, Question questionId,
			boolean verifyAnswer, User userId, Date postedTime) {
		super();
		this.answerId = id;
		this.description = description;
		this.questionId = questionId;
		this.verifyAnswer = verifyAnswer;
		this.userId = userId;
		this.postedTime = postedTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (answerId != other.answerId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (postedTime == null) {
			if (other.postedTime != null)
				return false;
		} else if (!postedTime.equals(other.postedTime))
			return false;
		if (verifyAnswer != other.verifyAnswer)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + answerId;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((postedTime == null) ? 0 : postedTime.hashCode());
		result = prime * result + (verifyAnswer ? 1231 : 1237);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", description=" + description
				+ ", verifyAnswer=" + verifyAnswer + ", postedTime="
				+ postedTime + "]";
	}
}
