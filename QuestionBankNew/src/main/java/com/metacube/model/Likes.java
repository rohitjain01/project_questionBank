/**
 * 
 */
package com.metacube.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Rohit
 *
 */
@Entity
@Table(name="likes")
@Data
public class Likes {
	
	@Id
	@Column(name="id")
	private int likeId;
	
	@Column(name="like_on")
	private boolean likeOn;
	
	@Column(name="islike")
	private boolean isLike;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
	private User userId;
	
	@Column(name="idCategory")
	private int questionAnswerID;
	
	public Likes() {
		
	}

	/**
	 * @param likeId
	 * @param likeOn
	 * @param isLike
	 * @param userId
	 * @param questionAnswerID
	 */
	public Likes(int likeId, boolean likeOn, boolean isLike, User userId,
			int questionAnswerID) {
		super();
		this.likeId = likeId;
		this.likeOn = likeOn;
		this.isLike = isLike;
		this.userId = userId;
		this.questionAnswerID = questionAnswerID;
	}

	
	
	
}
