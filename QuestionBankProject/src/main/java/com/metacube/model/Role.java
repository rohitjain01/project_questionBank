/**
 *Model class For setting the user types
 * 1. Normal user
 * 2. Login User
 * 3. Admin
 */
package com.metacube.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Team MJ
 *
 */
@Entity
@Table(name = "role")
@Data
public class Role {

	@Id
	@Column(name = "id")
	private int roleId;

	@Column(name = "role_type")
	private String roleType;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userRoleId")
	private Set<User> users = new HashSet<User>(0);

	/**
	 * Constructor
	 */
	public Role() {
		roleId = 0;
		roleType = "";
	}

	/**
	 * @param roleId
	 * @param roleType
	 * @param users
	 */
	public Role(int roleId, String roleType, Set<User> users) {
		this.roleId = roleId;
		this.roleType = roleType;
		this.users = users;
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
		Role other = (Role) obj;
		if (roleId != other.roleId)
			return false;
		if (roleType == null) {
			if (other.roleType != null)
				return false;
		} else if (!roleType.equals(other.roleType))
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
		result = prime * result + roleId;
		result = prime * result
				+ ((roleType == null) ? 0 : roleType.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleType=" + roleType + "]";
	}
}
