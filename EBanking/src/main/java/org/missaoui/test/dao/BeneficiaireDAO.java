package org.missaoui.test.dao;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.missaoui.test.model.Beneficiaire;
import org.missaoui.test.model.GoogleMail;
import org.missaoui.test.model.RandomString;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.api.services.gmail.Gmail;
 
@Repository
public class BeneficiaireDAO {
 
 @Autowired
 private SessionFactory sessionFactory;
 
 public void setSessionFactory(SessionFactory sf) {
  this.sessionFactory = sf;
 }
 
 public void updateStatutBeneficiaire (String idBeneficiaire, String newStatut)
 {
	 Session session = this.sessionFactory.getCurrentSession();
	 Beneficiaire beneficiaire = (Beneficiaire)session.get(Beneficiaire.class, new Integer(idBeneficiaire));
	 beneficiaire.setStatut(newStatut);
	 session.update(beneficiaire);
 }
 
 public String getCodeValidation(String idBeneficiaire)
 {
	 Session session = this.sessionFactory.getCurrentSession();
	 Beneficiaire beneficiaire = (Beneficiaire)session.get(Beneficiaire.class, new Integer(idBeneficiaire));
	 return beneficiaire.getCodeValidation();
 }
 
 public void setCodeValidation(String idBeneficiaire, String email)
 {
	 Session session = this.sessionFactory.getCurrentSession();
	 Beneficiaire beneficiaire = (Beneficiaire)session.get(Beneficiaire.class, new Integer(idBeneficiaire));
	 RandomString gen = new RandomString(11, ThreadLocalRandom.current());
	 String code = gen.nextString();
	 beneficiaire.setCodeValidation(code);
	 
	 GoogleMail.send("sadek.bfi@gmail.com","swagg_96",email,"Votre code de validation","Code : "+code);
 }
 
 public List getBeneficiairesValidesByAbonne(String idClient)
 {
	  Session session = this.sessionFactory.getCurrentSession();
	  List beneficiaires = session.createQuery("from Beneficiaire where idClient='"+idClient+"' AND statut='valide'").list();
	  return beneficiaires;
 }
 
 public List getBeneficiairesByAbonne(String idClient)
 {
	  Session session = this.sessionFactory.getCurrentSession();
	  List beneficiaires = session.createQuery("from Beneficiaire where idClient='"+idClient+"'").list();
	  return beneficiaires;
 }
 
 public Beneficiaire getBeneficiaireByNumeroCompte(String numeroCompte)
 {
	 String sql = "FROM Beneficiaire WHERE numeroCompte='"+numeroCompte+"'";
	 Session session = this.sessionFactory.getCurrentSession();
	 Beneficiaire beneficiaire = (Beneficiaire) session.createQuery(sql).list().get(0);
	 return beneficiaire;
 }
 
 public List getBeneficiairesByStatut(String statut)
 {
	  Session session = this.sessionFactory.getCurrentSession();
	  List beneficiaires = session.createQuery("from Beneficiaire where statut='"+statut+"'").list();
	  return beneficiaires;
 }
 
 public List getAllBeneficiaires() {
  Session session = this.sessionFactory.getCurrentSession();
  List beneficiaires = session.createQuery("from Beneficiaire").list();
  return beneficiaires;
 }
 
 public Beneficiaire getBeneficiaire(String idBeneficiaire) {
  Session session = this.sessionFactory.getCurrentSession();
  Beneficiaire beneficiaire = (Beneficiaire)session.get(Beneficiaire.class, new String(idBeneficiaire));
  //Beneficiaire beneficiaire = (Beneficiaire)session.createQuery("from Beneficiaire where BeneficiaireID="+idBeneficiaire).list().get(0);
  return beneficiaire;
 }
 
 public Beneficiaire addBeneficiaire(Beneficiaire beneficiaire) {
  Session session = this.sessionFactory.getCurrentSession();
  session.persist(beneficiaire);
  return beneficiaire;
 }
 
 public void updateBeneficiaire(Beneficiaire beneficiaire) {
  Session session = this.sessionFactory.getCurrentSession();
  session.update(beneficiaire);
 }
 
 public void deleteBeneficiaire(String idBeneficiaire) {
  Session session = this.sessionFactory.getCurrentSession();
  Beneficiaire p = (Beneficiaire)session.load(Beneficiaire.class, new Integer(idBeneficiaire));
  if (null != p) {
   session.delete(p);
  }
 } 
}