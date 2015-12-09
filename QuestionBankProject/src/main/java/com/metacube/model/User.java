/**
 *Model Class to add users in database
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;

/**
 * @author Team MJ
 *
 */
@Entity
@Table(name = "users")
@Data
public class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	// for auto number
	private int userId;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "user_name")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	private Role userRoleId;

	@Temporal(TemporalType.DATE)
	@Column(name = "account_creation_time")
	private Date accountCreationDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "account_updated_time")
	private Date accountUpdateDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login")
	private Date lastlogin;

	@Column(name = "password")
	private String password;

	@Transient
	private transient String confirmPassword;

	@Transient
	private transient String currentPassword;

	@Column(name = "image")
	private String image;

	@Column(name = "google_id")
	private String googleID;

	@Column(name = "isactive")
	private boolean userActive;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userId")
	private Set<Question> questions = new HashSet<Question>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userId")
	private Set<Answer> answers = new HashSet<Answer>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userId")
	private Set<Likes> likes = new HashSet<Likes>(0);

	/**
	 * Default Constructor
	 */
	public User() {

	}

	/**
	 * @param userId
	 * @param emailId
	 * @param name
	 * @param userRoleId
	 * @param accountCreationDate
	 * @param accountUpdateDate
	 * @param lastlogin
	 * @param password
	 * @param confirmPassword
	 * @param image
	 * @param googleID
	 * @param userActive
	 * @param questions
	 * @param answers
	 * @param likes
	 */
	public User(int userId, String emailId, String name, Role userRoleId,
			Date accountCreationDate, Date accountUpdateDate, Date lastlogin,
			String password, String confirmPassword, String image,
			String googleID, boolean userActive, Set<Question> questions,
			Set<Answer> answers, Set<Likes> likes) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.name = name;
		this.userRoleId = userRoleId;
		this.accountCreationDate = accountCreationDate;
		this.accountUpdateDate = accountUpdateDate;
		this.lastlogin = lastlogin;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.image = image;
		this.googleID = googleID;
		this.userActive = userActive;
		this.questions = questions;
		this.answers = answers;
		this.likes = likes;
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
		User other = (User) obj;
		if (accountCreationDate == null) {
			if (other.accountCreationDate != null)
				return false;
		} else if (!accountCreationDate.equals(other.accountCreationDate))
			return false;
		if (accountUpdateDate == null) {
			if (other.accountUpdateDate != null)
				return false;
		} else if (!accountUpdateDate.equals(other.accountUpdateDate))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (googleID == null) {
			if (other.googleID != null)
				return false;
		} else if (!googleID.equals(other.googleID))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (lastlogin == null) {
			if (other.lastlogin != null)
				return false;
		} else if (!lastlogin.equals(other.lastlogin))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userActive != other.userActive)
			return false;
		if (userId != other.userId)
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
		result = prime
				* result
				+ ((accountCreationDate == null) ? 0 : accountCreationDate
						.hashCode());
		result = prime
				* result
				+ ((accountUpdateDate == null) ? 0 : accountUpdateDate
						.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result
				+ ((googleID == null) ? 0 : googleID.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result
				+ ((lastlogin == null) ? 0 : lastlogin.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + (userActive ? 1231 : 1237);
		result = prime * result + userId;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", emailId=" + emailId + ", name="
				+ name + ", accountCreationDate=" + accountCreationDate
				+ ", accountUpdateDate=" + accountUpdateDate + ", lastlogin="
				+ lastlogin + ", password=" + password + ", image=" + image
				+ ", googleID=" + googleID + ", userActive=" + userActive + "]";
	}

}