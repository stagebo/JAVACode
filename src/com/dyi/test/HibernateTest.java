package com.dyi.test;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.dyi.hibernate.model.User;


public class HibernateTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tran=session.beginTransaction();
		User u = new User();
		u.setF_id(UUID.randomUUID().toString());
		u.setF_uid("sts");
		u.setF_pwd("sts");
		u.setF_reg_date(new Date());
		u.setF_exist(1);

		session.save(u);
		tran.commit();

		NativeQuery q=session.createSQLQuery("select * from t_user");
		
		List<Object[]> ul=q.list();
		for(Object[] o:ul){
			System.out.println(Arrays.toString(o));
		}
		session.close();
		
		
		System.out.println(new Date().toString());
	}
}
