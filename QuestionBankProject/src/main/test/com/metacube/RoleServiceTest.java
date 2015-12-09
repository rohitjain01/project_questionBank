package com.metacube;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Role;
import com.metacube.service.RoleService;
import com.metacube.service.impl.RoleServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"spring-servlet.xml"})
public class RoleServiceTest {

	@Autowired
	RoleService roleService = new RoleServiceImpl();
	
	


	@Transactional
	@Test
	public void testGetRole() throws QuestionBankSystemException, QuestionBankException{
		
		Role role=roleService.getRole(1);
		assertThat(role, instanceOf(Role.class));
	}
	
	@Transactional
	@Test
	public void testGetRoleFromRollType() throws QuestionBankSystemException, QuestionBankException{
		
	String roleName ="Normal User";
	Role role=roleService.getRoleFromRollType(roleName);
	assertThat(role, instanceOf(Role.class));
	
	
	}

}
