/** Model Class likes to store likes on post
 * 
 */
package com.metacube.model;

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

import lombok.Data;

/**
 * @author Team MJ
 *
 */
@Entity
@Table(name = "likes")
@Data
public class Likes {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int likeId;

	@Column(name = "like_on")
	private boolean likeOn;

	@Column(name = "islike")
	private boolean isLike;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User userId;

	@Column(name = "idCategory")
	private int questionAnswerId;

	/**
	 * Default constructor
	 */
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
			int questionAnswerId) {
		super();
		this.likeId = likeId;
		this.likeOn = likeOn;
		this.isLike = isLike;
		this.userId = userId;
		this.questionAnswerId = questionAnswerId;
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
		Likes other = (Likes) obj;
		if (isLike != other.isLike)
			return false;
		if (likeId != other.likeId)
			return false;
		if (likeOn != other.likeOn)
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
		result = prime * result + (isLike ? 1231 : 1237);
		result = prime * result + likeId;
		result = prime * result + (likeOn ? 1231 : 1237);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Likes [likeId=" + likeId + ", likeOn=" + likeOn + ", isLike="
				+ isLike + "]";
	}

}
