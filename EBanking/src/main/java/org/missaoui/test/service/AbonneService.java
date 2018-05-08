package org.missaoui.test.service;

import java.util.Date;
import java.util.List;
import org.missaoui.test.dao.AbonneDAO;
import org.missaoui.test.model.Abonne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service("abonneService")
public class AbonneService {
 
 @Autowired
 AbonneDAO abonneDAO;
 
 @Transactional
 public String getIdClientByCodeAbonne(String codeAbonne)
 {
	 return abonneDAO.getIdClientByCodeAbonne(codeAbonne);
 }
 
 @Transactional
 public Boolean verifPassword(String idClient, String oldPassword)
 {
	 return abonneDAO.verifPassword(idClient, oldPassword);
 }
 
 @Transactional
 public List getAllAbonnes() {
  return abonneDAO.getAllAbonnes();
 }
 
 @Transactional
 public List getAbonnesByDateCreation(String date1, String date2) {
  return abonneDAO.getAbonnesByDateCreation(date1, date2);
 }
 
 @Transactional
 public void updatePasswordAbonne(String idClient,  String newPassword) {
	 abonneDAO.updatePasswordAbonne(idClient, newPassword);
 }
 
 @Transactional
 public Abonne getAbonne(String idClient) {
  return abonneDAO.getAbonne(idClient);
 }
 
 @Transactional
 public void addAbonne(Abonne abonne) {
  abonneDAO.addAbonne(abonne);
 }
 
 @Transactional
 public void updateAbonne(Abonne abonne) {
  abonneDAO.updateAbonne(abonne);
 
 }
 
 @Transactional
 public void deleteAbonne(String idClient) {
  abonneDAO.deleteAbonne(idClient);
 }
}