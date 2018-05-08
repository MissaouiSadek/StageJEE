package org.missaoui.test.dao;

import java.util.List;

import org.missaoui.test.model.Abonne;
import org.missaoui.test.model.Administrateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
 
@Repository
public class AdministrateurDAO {
 
 @Autowired
 private SessionFactory sessionFactory;
 
 public void setSessionFactory(SessionFactory sf) {
  this.sessionFactory = sf;
 }
 
 public String getIdAdministrateurByUsername(String username) {
	  Session session = this.sessionFactory.getCurrentSession();
	  String sql= "from Administrateur where username='"+username+"'";
	  Administrateur admin= (Administrateur) session.createQuery(sql).list().get(0);
	  return admin.getIdAdministrateur();
	 }

public Boolean verifPassword(String idAdministrateur, String oldPassword)
{
	 Session session = this.sessionFactory.getCurrentSession();
	  String sql= "from Administrateur where idAdministrateur='"+idAdministrateur+"'";
	  Administrateur admin= (Administrateur) session.createQuery(sql).list().get(0);
	  PasswordEncoder encoder = new BCryptPasswordEncoder();
	  return (encoder.matches(oldPassword,admin.getPassword()));
}
 
 public void updatePassword(String idAdministrateur, String newPassword)
 {
	 Session session = this.sessionFactory.getCurrentSession();
	 Administrateur admin = (Administrateur)session.get(Administrateur.class, new String(idAdministrateur));
	 String newPasswordCrypt = BCrypt.hashpw(newPassword, BCrypt.gensalt(4));
	 admin.setPassword(newPasswordCrypt);
	 session.update(admin);
 }
 
 public List getAllAdministrateurs() {
  Session session = this.sessionFactory.getCurrentSession();
  List administrateurs = session.createQuery("from Administrateur").list();
  return administrateurs;
 }
 
 public Administrateur getAdministrateur(String idAdministrateur) {
  Session session = this.sessionFactory.getCurrentSession();
  Administrateur administrateur = (Administrateur)session.get(Administrateur.class, new String(idAdministrateur));
  return administrateur;
 }
 
 public Administrateur addAdministrateur(Administrateur administrateur) {
  Session session = this.sessionFactory.getCurrentSession();
  session.persist(administrateur);
  return administrateur;
 }
 
 public void updateAdministrateur(Administrateur administrateur) {
  Session session = this.sessionFactory.getCurrentSession();
  session.update(administrateur);
 }
 
 public void deleteAdministrateur(String idAdministrateur) {
  Session session = this.sessionFactory.getCurrentSession();
  Administrateur p = (Administrateur)session.load(Administrateur.class, new String(idAdministrateur));
  if (null != p) {
   session.delete(p);
  }
 } 
}
