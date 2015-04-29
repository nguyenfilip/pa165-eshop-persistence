package cz.fi.muni.pa165;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import cz.fi.muni.pa165.entity.User;


@ContextConfiguration(classes=PersistenceSampleApplicationContext.class)
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class SimplePersistTest  extends AbstractTransactionalTestNGSpringContextTests
{
	
	@PersistenceContext
	public EntityManager em;

	@Test
	public void userSave(){
		User user = new User();
		user.setEmail("fasdf@fasdfsd.cz");
		
		em.persist(user);
	}
}