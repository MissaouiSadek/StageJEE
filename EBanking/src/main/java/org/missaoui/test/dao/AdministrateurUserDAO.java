package org.missaoui.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.missaoui.test.model.Administrateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdministrateurUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Administrateur findByUserName(String username) {

		List<Administrateur> users = new ArrayList<Administrateur>();

		users = sessionFactory.getCurrentSession().createQuery("from Administrateur where username=?").setParameter(0, username)
				.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

}