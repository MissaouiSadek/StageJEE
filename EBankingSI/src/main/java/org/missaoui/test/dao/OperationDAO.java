package org.missaoui.test.dao;

import java.util.List;

import org.missaoui.test.model.Compte;
import org.missaoui.test.model.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class OperationDAO {
 
 @Autowired
 private SessionFactory sessionFactory;
 
 public void setSessionFactory(SessionFactory sf) {
  this.sessionFactory = sf;
 }
 
 public List getOperationsByNumeroCompte(String numeroCompte)
 {
	 String sql = "from Operation where RIB='"+numeroCompte+"'";
	 Session session = this.sessionFactory.getCurrentSession();
	 List operations = session.createQuery(sql).list();
	 return operations;
 }
 
 public List getOperationsByDate(String numeroCompte, String date1, String date2)
 {
	 String sql = "FROM Operation WHERE RIB='"+numeroCompte+"' AND DATEDIFF(dateOperation, '"+date1+"')>=0 AND DATEDIFF(dateOperation, '"+date2+"')<=0";
	 Session session = this.sessionFactory.getCurrentSession();
	 List operations = session.createQuery(sql).list();
	 return operations;
 }
 
 public List getAllOperations() {
  Session session = this.sessionFactory.getCurrentSession();
  List operations = session.createQuery("from Operation").list();
  return operations;
 }
 
 public Operation getOperation(int idOperation) {
  Session session = this.sessionFactory.getCurrentSession();
  Operation operation = (Operation)session.get(Operation.class, new Integer(idOperation));
  //Operation operation = (Operation)session.createQuery("from Operation where OperationID="+idOperation).list().get(0);
  return operation;
 }
 
 public Operation addOperation(Operation operation) {
  Session session = this.sessionFactory.getCurrentSession();
  String rib = operation.getCompte().getNumeroCompte();
  Compte compte = (Compte)session.get(Compte.class, new String(rib));
  compte.setSolde(compte.getSolde()+operation.getValeur());
  session.persist(operation);
  return operation;
 }
 
 public void updateOperation(Operation operation) {
  Session session = this.sessionFactory.getCurrentSession();
  session.update(operation);
 }
 
 public void deleteOperation(int idOperation) {
  Session session = this.sessionFactory.getCurrentSession();
  Operation p = (Operation)session.load(Operation.class, new Integer(idOperation));
  if (null != p) {
   session.delete(p);
  }
 } 
}