package com.metacube;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AnswerServiceTest.class, LikeServiceTest.class,
		QuestionServiceTest.class, QuestionTagServiceTest.class,
		RoleServiceTest.class, UserServiceTest.class })
public class AllTests {

}
