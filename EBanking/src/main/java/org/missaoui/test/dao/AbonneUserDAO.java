package org.missaoui.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.missaoui.test.model.Abonne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AbonneUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Abonne findByUserName(String codeAbonne) {

		List<Abonne> users = new ArrayList<Abonne>();

		users = sessionFactory.getCurrentSession().createQuery("from Abonne where codeAbonne=?").setParameter(0, codeAbonne)
				.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

}