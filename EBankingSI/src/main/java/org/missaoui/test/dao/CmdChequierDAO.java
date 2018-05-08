package org.missaoui.test.dao;

import java.util.List;

import org.missaoui.test.model.CmdChequier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
 
@Repository
public class CmdChequierDAO {
 
 @Autowired
 private SessionFactory sessionFactory;
 
 public List getCmdsChequierByClient(String idClient)
 {
	 String sql = "from CmdChequier where idClient='"+idClient+"'";
	 Session session = this.sessionFactory.getCurrentSession();
	 List cmdsChequier = session.createQuery(sql).list();
	 return cmdsChequier;
 }
 
 public void updateStatutCmdChequier (int idCmdChequier, String newStatut)
 {
	 Session session = this.sessionFactory.getCurrentSession();
	 CmdChequier cmdChequier = (CmdChequier)session.get(CmdChequier.class, new Integer(idCmdChequier));
	 cmdChequier.setStatut(newStatut);
	 session.update(cmdChequier);
 }
 
 public List getCmdsChequierByNumeroCompte(String numeroCompte)
 {
	 String sql = "from CmdChequier where numeroCompte='"+numeroCompte+"'";
	 Session session = this.sessionFactory.getCurrentSession();
	 List cmdsChequier = session.createQuery(sql).list();
	 return cmdsChequier;
 }
 
 public void setSessionFactory(SessionFactory sf) {
  this.sessionFactory = sf;
 }
 
 public List getAllCmdsChequier() {
  Session session = this.sessionFactory.getCurrentSession();
  List cmdsChequier = session.createQuery("from CmdChequier").list();
  return cmdsChequier;
 }
 
 public CmdChequier getCmdChequier(int idCmdChequier) {
  Session session = this.sessionFactory.getCurrentSession();
  CmdChequier cmdChequier = (CmdChequier)session.get(CmdChequier.class, new Integer(idCmdChequier));
  //CmdChequier cmdChequier = (CmdChequier)session.createQuery("from CmdChequier where CmdChequierID="+idCmdChequier).list().get(0);
  return cmdChequier;
 }
 
 public CmdChequier addCmdChequier(CmdChequier cmdChequier) {
  Session session = this.sessionFactory.getCurrentSession();
  session.persist(cmdChequier);
  return cmdChequier;
 }
 
 public void updateCmdChequier(CmdChequier cmdChequier) {
  Session session = this.sessionFactory.getCurrentSession();
  session.update(cmdChequier);
 }
 
 public void deleteCmdChequier(int idCmdChequier) {
  Session session = this.sessionFactory.getCurrentSession();
  CmdChequier p = (CmdChequier)session.load(CmdChequier.class, new Integer(idCmdChequier));
  if (null != p) {
   session.delete(p);
  }
 } 
}