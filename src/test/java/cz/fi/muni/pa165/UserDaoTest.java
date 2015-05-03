package cz.fi.muni.pa165;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import cz.fi.muni.pa165.dao.UserDao;
import cz.fi.muni.pa165.entity.User;


@ContextConfiguration(classes=PersistenceSampleApplicationContext.class)
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class UserDaoTest  extends AbstractTransactionalTestNGSpringContextTests
{
	
	@Autowired
	public UserDao dao;

	@Test
	public void userAdd(){
		User u = new User();
		u.setEmail("fff@edd.cz");
		dao.create(u);
		
		User u2 = new User();
		u2.setEmail("fffx@edd.cz");
		dao.create(u2);
		
		User x = dao.findUserByEmail("fff@edd.cz");
		System.out.println(x);
	}
	
}