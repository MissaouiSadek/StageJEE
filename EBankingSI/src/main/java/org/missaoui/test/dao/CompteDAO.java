package org.missaoui.test.dao;

import java.util.List;

import org.missaoui.test.model.Compte;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class CompteDAO {
 
 @Autowired
 private SessionFactory sessionFactory;
 
 public void setSessionFactory(SessionFactory sf) {
  this.sessionFactory = sf;
 }
 
 public List getComptesByIdClient(String idClient) {
	  Session session = this.sessionFactory.getCurrentSession();
	  List comptes = session.createQuery("from Compte where idClient='"+idClient+"'").list();
	  return comptes;
	 }
 
 public List getAllComptes() {
  Session session = this.sessionFactory.getCurrentSession();
  List comptes = session.createQuery("from Compte").list();
  return comptes;
 }
 
 public Compte getCompte(String RIB) {
  Session session = this.sessionFactory.getCurrentSession();
  Compte compte = (Compte)session.get(Compte.class, new String(RIB));
  return compte;
 }
 
 public Compte addCompte(Compte compte) {
  Session session = this.sessionFactory.getCurrentSession();
  session.persist(compte);
  return compte;
 }
 
 public void updateCompte(Compte compte) {
  Session session = this.sessionFactory.getCurrentSession();
  session.update(compte);
 }
 
 public void deleteCompte(String RIB) {
  Session session = this.sessionFactory.getCurrentSession();
  Compte p = (Compte)session.load(Compte.class, new String(RIB));
  if (null != p) {
   session.delete(p);
  }
 } 
}