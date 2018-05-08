package org.missaoui.test.dao;

import java.util.List;

import org.missaoui.test.model.CmdCarte;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
 
@Repository
public class CmdCarteDAO {
 
 @Autowired
 private SessionFactory sessionFactory;
 
 public List getCmdsCarteByClient(String idClient)
 {
	 String sql = "from CmdCarte where idClient='"+idClient+"'";
	 Session session = this.sessionFactory.getCurrentSession();
	 List cmdsCarte = session.createQuery(sql).list();
	 return cmdsCarte;
 }
 
 public void updateStatutCmdCarte (int idCmdCarte, String newStatut)
 {
	 Session session = this.sessionFactory.getCurrentSession();
	 CmdCarte cmdCarte = (CmdCarte)session.get(CmdCarte.class, new Integer(idCmdCarte));
	 cmdCarte.setStatut(newStatut);
	 session.update(cmdCarte);
 }
 
 public List getCmdsCarteByNumeroCompte(String numeroCompte)
 {
	 String sql = "from CmdCarte where numeroCompte='"+numeroCompte+"'";
	 Session session = this.sessionFactory.getCurrentSession();
	 List cmdsCarte = session.createQuery(sql).list();
	 return cmdsCarte;
 }
 
 public void setSessionFactory(SessionFactory sf) {
  this.sessionFactory = sf;
 }
 
 public List getAllCmdsCarte() {
  Session session = this.sessionFactory.getCurrentSession();
  List cmdsCarte = session.createQuery("from CmdCarte").list();
  return cmdsCarte;
 }
 
 public CmdCarte getCmdCarte(int idCmdCarte) {
  Session session = this.sessionFactory.getCurrentSession();
  CmdCarte cmdCarte = (CmdCarte)session.get(CmdCarte.class, new Integer(idCmdCarte));
  //CmdCarte cmdCarte = (CmdCarte)session.createQuery("from CmdCarte where CmdCarteID="+idCmdCarte).list().get(0);
  return cmdCarte;
 }
 
 public CmdCarte addCmdCarte(CmdCarte cmdCarte) {
  Session session = this.sessionFactory.getCurrentSession();
  session.persist(cmdCarte);
  return cmdCarte;
 }
 
 public void updateCmdCarte(CmdCarte cmdCarte) {
  Session session = this.sessionFactory.getCurrentSession();
  session.update(cmdCarte);
 }
 
 public void deleteCmdCarte(int idCmdCarte) {
  Session session = this.sessionFactory.getCurrentSession();
  CmdCarte p = (CmdCarte)session.load(CmdCarte.class, new Integer(idCmdCarte));
  if (null != p) {
   session.delete(p);
  }
 } 
}