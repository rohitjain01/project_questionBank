/**
 * 
 */
package com.metacube.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Rohit
 *
 */
@Entity
@Table(name="role")
@Data
public class Role {
	
	@Id
	@Column(name="id")
	private int roleId;
	
	@Column(name="role_type")
	private String roleType;
	
	@OneToMany(mappedBy="userRoleId")
    private Set<User> users;
	
	public Role() {
		
	}

	/**
	 * @param roleId
	 * @param roleType
	 * @param users
	 */
	public Role(int roleId, String roleType, Set<User> users) {
		super();
		this.roleId = roleId;
		this.roleType = roleType;
		this.users = users;
	}
}
