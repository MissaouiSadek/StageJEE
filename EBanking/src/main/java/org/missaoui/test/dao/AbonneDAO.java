package org.missaoui.test.dao;

import java.util.List;

import org.missaoui.test.model.Abonne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
 
@Repository
public class AbonneDAO {
	
 @Autowired
 private SessionFactory sessionFactory;
 
 public void setSessionFactory(SessionFactory sf) {
  this.sessionFactory = sf;
 }
 
 public String getIdClientByCodeAbonne(String codeAbonne) {
	  Session session = this.sessionFactory.getCurrentSession();
	  String sql= "from Abonne where codeAbonne='"+codeAbonne+"'";
	  Abonne abonne= (Abonne) session.createQuery(sql).list().get(0);
	  return abonne.getIdClient();
	 }
 
 public Boolean verifPassword(String idClient, String oldPassword)
 {
	 Session session = this.sessionFactory.getCurrentSession();
	  String sql= "from Abonne where idClient='"+idClient+"'";
	  Abonne abonne= (Abonne) session.createQuery(sql).list().get(0);
	  PasswordEncoder encoder = new BCryptPasswordEncoder();
	  return (encoder.matches(oldPassword,abonne.getPasswordAbonne()));
 }
 
 public List getAbonnesByDateCreation(String date1, String date2)
 {
	 String sql = "FROM Abonne WHERE DATEDIFF(dateCreation, '"+date1+"')>=0 AND DATEDIFF(dateCreation, '"+date2+"')<=0";
	 Session session = this.sessionFactory.getCurrentSession();
	 List abonnes = session.createQuery(sql).list();
	 return abonnes;
 }
 
 public void updatePasswordAbonne (String idClient, String newPassword)
 {
	 Session session = this.sessionFactory.getCurrentSession();
	 Abonne abonne = (Abonne)session.get(Abonne.class, new String(idClient));
	 String newPasswordCrypt = BCrypt.hashpw(newPassword, BCrypt.gensalt(4));
	 abonne.setPasswordAbonne(newPasswordCrypt);
	 session.update(abonne);
 }
 
 public List getAllAbonnes() {
  Session session = this.sessionFactory.getCurrentSession();
  List abonnes = session.createQuery("from Abonne").list();
  return abonnes;
 }
 
 public Abonne getAbonne(String idClient) {
  Session session = this.sessionFactory.getCurrentSession();
  Abonne abonne = (Abonne)session.get(Abonne.class, new String(idClient));
  return abonne;
 }
 
 public Abonne addAbonne(Abonne abonne) {
  Session session = this.sessionFactory.getCurrentSession();
  String passwordCrypt = BCrypt.hashpw(abonne.getPasswordAbonne(), BCrypt.gensalt(4));
  abonne.setPasswordAbonne(passwordCrypt);
  session.persist(abonne);
  return abonne;
 }
 
 public void updateAbonne(Abonne abonne) {
  Session session = this.sessionFactory.getCurrentSession();
  session.update(abonne);
 }
 
 public void deleteAbonne(String idClient) {
  Session session = this.sessionFactory.getCurrentSession();
  Abonne p = (Abonne)session.load(Abonne.class, new String(idClient));
  if (null != p) {
   session.delete(p);
  }
 } 
}