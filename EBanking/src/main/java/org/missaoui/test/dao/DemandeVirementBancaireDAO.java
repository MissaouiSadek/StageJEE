package org.missaoui.test.dao;

import java.util.List;

import org.missaoui.test.model.Abonne;
import org.missaoui.test.model.DemandeVirementBancaire;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
 
@Repository
public class DemandeVirementBancaireDAO {
 
 @Autowired
 private SessionFactory sessionFactory;
 
 public void setSessionFactory(SessionFactory sf) {
  this.sessionFactory = sf;
 }
 
 public void updateStatut (int idDemandeVirementBancaire, String newStatut)
 {
	 Session session = this.sessionFactory.getCurrentSession();
	 DemandeVirementBancaire demandeVirementBancaire = (DemandeVirementBancaire)session.get(DemandeVirementBancaire.class, new Integer(idDemandeVirementBancaire));
	 demandeVirementBancaire.setStatut(newStatut);
	 session.update(demandeVirementBancaire);
 }
 
 public List getDemandesInterByDate(String date1, String date2)
 {
	 String sql = "FROM DemandeVirementBancaire WHERE DATEDIFF(dateVirement, '"+date1+"')>=0 AND DATEDIFF(dateVirement, '"+date2+"')<=0";
	 Session session = this.sessionFactory.getCurrentSession();
	 List demandeVirementBancaires = session.createQuery(sql).list();
	 return demandeVirementBancaires;
 }
 
 public List getDemandesInterByDestinataire(String RIBdestinataire)
 {
	 String sql = "FROM DemandeVirementBancaire WHERE RIBdestinataire='"+RIBdestinataire+"'";
	 Session session = this.sessionFactory.getCurrentSession();
	 List demandeVirementBancaires = session.createQuery(sql).list();
	 return demandeVirementBancaires;
 }
 
 public List getDemandesInterByExpediteur(String RIBexpediteur)
 {
	 String sql = "FROM DemandeVirementBancaire WHERE RIBexpediteur='"+RIBexpediteur+"'";
	 Session session = this.sessionFactory.getCurrentSession();
	 List demandeVirementBancaires = session.createQuery(sql).list();
	 return demandeVirementBancaires;
 }
 
 public List getDemandesInterByBanque(String banqueDestinataire)
 {
	 String sql = "FROM DemandeVirementBancaire WHERE banqueDestinataire='"+banqueDestinataire+"'";
	 Session session = this.sessionFactory.getCurrentSession();
	 List demandeVirementBancaires = session.createQuery(sql).list();
	 return demandeVirementBancaires;
 }
 
 public List getAllDemandeVirementBancaires() {
  Session session = this.sessionFactory.getCurrentSession();
  List demandeVirementBancaires = session.createQuery("from DemandeVirementBancaire").list();
  return demandeVirementBancaires;
 }
 
 public DemandeVirementBancaire getDemandeVirementBancaire(int idDemandeVirementBancaire) {
  Session session = this.sessionFactory.getCurrentSession();
  DemandeVirementBancaire demandeVirementBancaire = (DemandeVirementBancaire)session.get(DemandeVirementBancaire.class, new Integer(idDemandeVirementBancaire));
  //DemandeVirementBancaire demandeVirementBancaire = (DemandeVirementBancaire)session.createQuery("from DemandeVirementBancaire where DemandeVirementBancaireID="+idDemandeVirementBancaire).list().get(0);
  return demandeVirementBancaire;
 }
 
 public DemandeVirementBancaire addDemandeVirementBancaire(DemandeVirementBancaire demandeVirementBancaire) {
  Session session = this.sessionFactory.getCurrentSession();
  session.persist(demandeVirementBancaire);
  return demandeVirementBancaire;
 }
 
 public void updateDemandeVirementBancaire(DemandeVirementBancaire demandeVirementBancaire) {
  Session session = this.sessionFactory.getCurrentSession();
  session.update(demandeVirementBancaire);
 }
 
 public void deleteDemandeVirementBancaire(int idDemandeVirementBancaire) {
  Session session = this.sessionFactory.getCurrentSession();
  DemandeVirementBancaire p = (DemandeVirementBancaire)session.load(DemandeVirementBancaire.class, new Integer(idDemandeVirementBancaire));
  if (null != p) {
   session.delete(p);
  }
 } 
}
