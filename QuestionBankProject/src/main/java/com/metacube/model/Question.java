/**
Model Class to store all the questions posted by different users
 * 
 */
package com.metacube.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author Team MJ
 *
 */
@Entity
@Table(name = "question")
@Data
public class Question {
	@Id
	@Column(name = "question_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	// for auto number
	private int questionId;

	@Column(name = "title")
	private String questionTitle;

	@Column(name = "description", length = 1000)
	private String questionDescription;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User userId;

	@Column(name = "isopen")
	private boolean openQuestion;

	@Temporal(TemporalType.DATE)
	@Column(name = "created_time")
	private Date postedTime;

	@Temporal(TemporalType.DATE)
	@Column(name = "updated_time")
	private Date updatedTime;

	@Column(name = "hits")
	private int noOfViews;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "questionId")
	private Set<Answer> answers = new HashSet<Answer>(0);

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "tags_questions", joinColumns = { @JoinColumn(name = "question_id") }, inverseJoinColumns = { @JoinColumn(name = "tag_id") })
	private Set<QuestionTag> tags = new HashSet<QuestionTag>(0);

	/**
	 * Default Constructor
	 */
	public Question() {

	}

	/**
	 * @param questionId
	 * @param questionTitle
	 * @param questionDescription
	 * @param userId
	 * @param openQuestion
	 * @param postedTime
	 * @param updatedTime
	 * @param noOfViews
	 */
	public Question(int questionId, String questionTitle,
			String questionDescription, User userId, boolean openQuestion,
			Date postedTime, Date updatedTime, int noOfViews) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.questionDescription = questionDescription;
		this.userId = userId;
		this.openQuestion = openQuestion;
		this.postedTime = postedTime;
		this.updatedTime = updatedTime;
		this.noOfViews = noOfViews;
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
		Question other = (Question) obj;
		if (noOfViews != other.noOfViews)
			return false;
		if (openQuestion != other.openQuestion)
			return false;
		if (postedTime == null) {
			if (other.postedTime != null)
				return false;
		} else if (!postedTime.equals(other.postedTime))
			return false;
		if (questionDescription == null) {
			if (other.questionDescription != null)
				return false;
		} else if (!questionDescription.equals(other.questionDescription))
			return false;
		if (questionId != other.questionId)
			return false;
		if (questionTitle == null) {
			if (other.questionTitle != null)
				return false;
		} else if (!questionTitle.equals(other.questionTitle))
			return false;
		if (updatedTime == null) {
			if (other.updatedTime != null)
				return false;
		} else if (!updatedTime.equals(other.updatedTime))
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
		result = prime * result + noOfViews;
		result = prime * result + (openQuestion ? 1231 : 1237);
		result = prime * result
				+ ((postedTime == null) ? 0 : postedTime.hashCode());
		result = prime
				* result
				+ ((questionDescription == null) ? 0 : questionDescription
						.hashCode());
		result = prime * result + questionId;
		result = prime * result
				+ ((questionTitle == null) ? 0 : questionTitle.hashCode());
		result = prime * result
				+ ((updatedTime == null) ? 0 : updatedTime.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionTitle="
				+ questionTitle + ", questionDescription="
				+ questionDescription + ", openQuestion=" + openQuestion
				+ ", postedTime=" + postedTime + ", updatedTime=" + updatedTime
				+ ", noOfViews=" + noOfViews + "]";
	}
}