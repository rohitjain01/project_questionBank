/**
 * 
 */
package com.metacube.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author Rohit
 *
 */
@Entity
@Table(name="tag")
@Data
public class QuestionTag {
	@Id
	@Column(name="tag_id")
	@GeneratedValue(strategy = GenerationType.AUTO)// for auto number
	private int tagId;
	
	@Column(name="tag_name")
	private String tagName;
	
	@Column(name="description")
	private String tagDesciption;
	
	@Column(name="tag_creation_date")
	@Temporal(TemporalType.DATE)
	private Date tagCreationDate;
	
	public QuestionTag() {
		
	}
	/**
	 * @param tagId
	 * @param tagName
	 * @param tagDesciption
	 * @param tagCreationDa
	 */
	public QuestionTag(int tagId, String tagName, String tagDesciption,
			Date tagCreationDate) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagDesciption = tagDesciption;
		this.tagCreationDate = tagCreationDate;
	}
}
