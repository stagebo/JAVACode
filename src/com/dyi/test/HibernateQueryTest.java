package com.dyi.test;

import java.util.List;

import org.hibernate.Session;

import com.dyi.hibernate.SessionManager;
import com.dyi.hibernate.model.User;

public class HibernateQueryTest {
	public static void main(String[] args) {
		Session session = SessionManager.openSession();
		List<User> l = session.createQuery("").list();
		if (l == null)
			System.out.println("error");
		else {
			for(User u:l)
				System.out.println(u.toString());
		}
	}
}
