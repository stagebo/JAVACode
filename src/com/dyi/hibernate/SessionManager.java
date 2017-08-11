package com.dyi.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Sessionπ‹¿Ì¿‡
 * @author WANYONGBO
 * @version 2017-8-11 17:01:22
 */
public class SessionManager {
	static {
		Configuration configuration = new Configuration();
		configuration.configure("/hibernate.cfg.xml");
		_sessionFactory = configuration.buildSessionFactory();
	}
	private static SessionFactory _sessionFactory;
	private static Session _session;

	public static Session openSession() {
		Session session = null;
		try {
			session = _sessionFactory.openSession();
			return session;
		} catch (Exception ex) {
			return null;
		}
	}

	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
	
}
