package com.dyi.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dyi.hibernate.SessionManager;
import com.dyi.hibernate.model.User;

import org.hibernate.Session;
public class SessionManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testOpenSession() {
		Session session = SessionManager.openSession();
		List<User> l = session.createQuery("select * from t_user").list();
		/*
		for(User u:l)System.out.println(u.toString());
		assertNotSame(1,1);*/
	}

}
