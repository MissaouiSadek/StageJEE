package org.missaoui.test.service;

import java.util.List;
import org.missaoui.test.dao.CompteDAO;
import org.missaoui.test.model.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service("compteService")
public class CompteService {
 
 @Autowired
 CompteDAO compteDAO;
 
 @Transactional
 public List getAllComptes() {
	 return compteDAO.getAllComptes();
 }
 
 @Transactional
 public List getComptesByIdClient(String idClient)
 {
	 return compteDAO.getComptesByIdClient(idClient);
 }
 
 @Transactional
 public Compte getCompte(String RIB) {
  return compteDAO.getCompte(RIB);
 }
 
 @Transactional
 public void addCompte(Compte compte) {
  compteDAO.addCompte(compte);
 }
 
 @Transactional
 public void updateCompte(Compte compte) {
  compteDAO.updateCompte(compte);
 
 }
 
 @Transactional
 public void deleteCompte(String RIB) {
  compteDAO.deleteCompte(RIB);
 }
}