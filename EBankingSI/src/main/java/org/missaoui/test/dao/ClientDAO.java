package org.missaoui.test.dao;

import java.util.List;

import org.missaoui.test.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class ClientDAO {
 
 @Autowired
 private SessionFactory sessionFactory;
 
 public void setSessionFactory(SessionFactory sf) {
  this.sessionFactory = sf;
 }
 
 public List getAllClients() {
  Session session = this.sessionFactory.getCurrentSession();
  List clients = session.createQuery("from Client").list();
  return clients;
 }
 
 public Client getClient(String idClient) {
  Session session = this.sessionFactory.getCurrentSession();
  Client client = (Client)session.get(Client.class, new String(idClient));
  //Client client = (Client)session.createQuery("from Client where ClientID="+idClient).list().get(0);
  return client;
 }
 
 public Client addClient(Client client) {
  Session session = this.sessionFactory.getCurrentSession();
  session.persist(client);
  return client;
 }
 
 public void updateClient(Client client) {
  Session session = this.sessionFactory.getCurrentSession();
  session.update(client);
 }
 
 public void deleteClient(String idClient) {
  Session session = this.sessionFactory.getCurrentSession();
  Client p = (Client)session.load(Client.class, new String(idClient));
  if (null != p) {
   session.delete(p);
  }
 } 
}