package com.dyi.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import com.dyi.hibernate.SessionManager;
import com.dyi.hibernate.model.User;

public class HibernateQueryTest {
	public static void main(String[] args) {
		
		Session session = SessionManager.openSession();
		/*List<Object[]> l = session.createQuery("select * from t_user").list();
		if (l == null)
			System.out.println("error");
		else {
			for(Object[] u:l)
				System.out.println(Arrays.toString(u));
		}*/
	}
}
