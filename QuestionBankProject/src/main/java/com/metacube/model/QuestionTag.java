/**

 * Model Class to store tags 
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
 * @author Team MJ
 *
 */
@Entity
@Table(name = "tag")
@Data
public class QuestionTag {

	@Id
	@Column(name = "tag_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	// for auto number
	private int tagId;

	@Column(name = "tag_name")
	private String tagName;

	@Column(name = "description")
	private String tagDesciption;

	@Column(name = "tag_creation_date")
	@Temporal(TemporalType.DATE)
	private Date tagCreationDate;

	/**
	 * default constructor
	 */
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
		QuestionTag other = (QuestionTag) obj;
		if (tagCreationDate == null) {
			if (other.tagCreationDate != null)
				return false;
		} else if (!tagCreationDate.equals(other.tagCreationDate))
			return false;
		if (tagDesciption == null) {
			if (other.tagDesciption != null)
				return false;
		} else if (!tagDesciption.equals(other.tagDesciption))
			return false;
		if (tagId != other.tagId)
			return false;
		if (tagName == null) {
			if (other.tagName != null)
				return false;
		} else if (!tagName.equals(other.tagName))
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
		result = prime * result
				+ ((tagCreationDate == null) ? 0 : tagCreationDate.hashCode());
		result = prime * result
				+ ((tagDesciption == null) ? 0 : tagDesciption.hashCode());
		result = prime * result + tagId;
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QuestionTag [tagId=" + tagId + ", tagName=" + tagName
				+ ", tagDesciption=" + tagDesciption + ", tagCreationDate="
				+ tagCreationDate + "]";
	}
}
