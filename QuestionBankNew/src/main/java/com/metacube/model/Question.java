/**
 * 
 */
package com.metacube.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Rohit
 *
 */
@Entity
@Table(name="question")
@Data
public class Question {
	@Id
	@Column(name="question_id")
	@GeneratedValue(strategy = GenerationType.AUTO)// for auto number
	private int questionId;
	
	@Column(name="title")
	private String questionTitle;
	
	@Column(name="description", length=1000)
	private String questionDescription;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
	private User userId;
	
	@Column(name="isopen")
	private boolean openQuestion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="created_time")
	private Date postedTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name="updated_time")
	private Date updatedTime;
	
	@Column(name="hits")
	private int noOfViews;
	
	@OneToMany(mappedBy="questionId")
	private Set<Answer> answers;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tags_questions", joinColumns = { @JoinColumn(name = "question_id") }, inverseJoinColumns = { @JoinColumn(name = "tag_id") })
	private Set<QuestionTag> tags = new HashSet<QuestionTag>(0);
	
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
}