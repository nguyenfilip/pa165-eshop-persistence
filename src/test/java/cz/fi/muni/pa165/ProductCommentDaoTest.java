package cz.fi.muni.pa165;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import cz.fi.muni.pa165.dao.ProductCommentDao;
import cz.fi.muni.pa165.dao.ProductDao;
import cz.fi.muni.pa165.dao.UserDao;
import cz.fi.muni.pa165.entity.Product;
import cz.fi.muni.pa165.entity.ProductComment;
import cz.fi.muni.pa165.entity.User;


@ContextConfiguration(classes=PersistenceSampleApplicationContext.class)
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductCommentDaoTest  extends AbstractTransactionalTestNGSpringContextTests
{
	@PersistenceContext
	public EntityManager em;
	
	@Autowired
	public ProductDao productDao;

	@Autowired
	public UserDao userDao;

	@Autowired
	public ProductCommentDao productCommentDao;
	
	@Test
	public void productDaoTest(){
		Product product = new Product();
		product.setName("LG TV X2");
		User user = new User();
		user.setEmail("Filip@Filip.cz");
		user.setGivenName("Martin");
		user.setSurname("Marek");
		user.setJoinedDate(new Date());
		
		productDao.create(product);
		userDao.create(user);
		
		ProductComment comment = new ProductComment();
		comment.setText("Ahoj!");
		comment.setProduct(product);
		comment.setUser(user);
		comment.setCreated(new Date());
		
		productCommentDao.create(comment);
	
		em.clear();
		
		User u = userDao.findUserByEmail("Filip@Filip.cz");
		System.out.println(u.getComments().size());
		
		Product p = productDao.findById(product.getId());
		System.out.println(p.getComments().size());
	}
}