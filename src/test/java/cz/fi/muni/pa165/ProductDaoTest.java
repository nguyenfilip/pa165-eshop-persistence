package cz.fi.muni.pa165;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import cz.fi.muni.pa165.dao.CategoryDaoImpl;
import cz.fi.muni.pa165.dao.ProductDaoImpl;
import cz.fi.muni.pa165.entity.Category;
import cz.fi.muni.pa165.entity.Product;


@ContextConfiguration(classes=PersistenceSampleApplicationContext.class)
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductDaoTest  extends AbstractTransactionalTestNGSpringContextTests
{
	@PersistenceContext
	public EntityManager em;
	
	@Autowired
	public ProductDaoImpl dao;

	@Autowired
	public CategoryDaoImpl categoryDao;

	
	@Test
	public void productDaoTest(){
		Category c = new Category();
		c.setName("Elektro");
		categoryDao.create(c);
		
		Product p  = new Product();
		p.setName("LCD TV");
		p.addCategory(c);
		dao.create(p);
		
		
		List<Category> categories = categoryDao.findAll();
		System.out.println(categories.iterator().next().getProducts().size());
	}
	

	@Test
	public void productCategoryTest(){
		Category c = new Category();
		c.setName("Elektro");
		categoryDao.create(c);
		
		Product p  = new Product();
		p.setName("LCD TV");
		dao.create(p);
		
		em.flush();
		em.clear();
//		
////		c = categoryDao.findById(c.getId());
//		p = dao.findById(p.getId());
		dao.update(p);
		p.addCategory(c);
		
		
		
		em.flush();
		em.clear();
		
		List<Category> categories = categoryDao.findAll();
		System.out.println(categories.iterator().next().getProducts().size());
	}
}