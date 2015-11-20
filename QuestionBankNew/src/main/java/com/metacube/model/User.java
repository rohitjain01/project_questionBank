package com.metacube.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)// for auto number
	private int userId;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="user_name")
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_id")
	private Role userRoleId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="account_creation_time")
	private Date accountCreationDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="account_updated_time")
	private Date accountUpdateDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="last_login")
	private Date lastlogin;
	
	@Column(name="password")
	private String password;
	
	@Column(name="image")
	private String image;
	
	@Column(name="google_id")
	private String googleID;
	
	@Column(name="isactive")
	private boolean userActive;
	
	@OneToMany(mappedBy="userId")
	private Set<Question> questions;
	
	@OneToMany(mappedBy="userId")
	private Set<Answer> answers;
	
	@OneToMany(mappedBy="userId")
	private Set<Likes> likes;
	
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
	 * @param image
	 * @param googleID
	 * @param userActive
	 * @param questions
	 * @param answers
	 * @param likes
	 */
	public User(int userId, String emailId, String name, Role userRoleId,
			Date accountCreationDate, Date accountUpdateDate, Date lastlogin,
			String password, String image, String googleID, boolean userActive,
			Set<Question> questions, Set<Answer> answers, Set<Likes> likes) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.name = name;
		this.userRoleId = userRoleId;
		this.accountCreationDate = accountCreationDate;
		this.accountUpdateDate = accountUpdateDate;
		this.lastlogin = lastlogin;
		this.password = password;
		this.image = image;
		this.googleID = googleID;
		this.userActive = userActive;
		this.questions = questions;
		this.answers = answers;
		this.likes = likes;
	}
	
}