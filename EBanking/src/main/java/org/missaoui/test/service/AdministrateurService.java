package org.missaoui.test.service;

import java.util.List;
import org.missaoui.test.dao.AdministrateurDAO;
import org.missaoui.test.model.Administrateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service("administrateurService")
public class AdministrateurService {
 
 @Autowired
 AdministrateurDAO administrateurDAO;
 
 @Transactional
 public String getIdAdministrateurByUsername(String username)
 {
	 return administrateurDAO.getIdAdministrateurByUsername(username);
 }
 
 @Transactional
 public Boolean verifPassword(String idAdministrateur, String oldPassword)
 {
	 return administrateurDAO.verifPassword(idAdministrateur, oldPassword);
 }
 
 @Transactional
 public void updatePassword(String idAdministrateur, String newPassword)
 {
	 administrateurDAO.updatePassword(idAdministrateur, newPassword);
 }
 
 @Transactional
 public List getAllAdministrateurs() {
  return administrateurDAO.getAllAdministrateurs();
 }
 
 @Transactional
 public Administrateur getAdministrateur(String idAdministrateur) {
  return administrateurDAO.getAdministrateur(idAdministrateur);
 }
 
 @Transactional
 public void addAdministrateur(Administrateur administrateur) {
  administrateurDAO.addAdministrateur(administrateur);
 }
 
 @Transactional
 public void updateAdministrateur(Administrateur administrateur) {
  administrateurDAO.updateAdministrateur(administrateur);
 
 }
 
 @Transactional
 public void deleteAdministrateur(String idAdministrateur) {
  administrateurDAO.deleteAdministrateur(idAdministrateur);
 }
}
