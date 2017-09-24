package com.dyi.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.dyi.hibernate.HibernateSessionFactory;

public class HibernateJTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetSession() {
		System.out.println(123);
		Session session = HibernateSessionFactory.getSession();
		/*List l = session.createQuery("select * from t_user").list();
		for(Object o:l){
			System.out.println(o);
		}*/
	}

	@Test
	public void testRebuildSessionFactory() {
		
	}

	@Test
	public void testGetSessionFactory() {
		
	}

}
