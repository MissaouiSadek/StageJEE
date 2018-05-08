package org.missaoui.test.service;

import java.util.List;
import org.missaoui.test.dao.DemandeVirementBancaireDAO;
import org.missaoui.test.model.DemandeVirementBancaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service("demandeVirementBancaireService")
public class DemandeVirementBancaireService {
 
 @Autowired
 DemandeVirementBancaireDAO demandeVirementBancaireDAO;
 
 @Transactional
 public List getDemandesInterByDate(String date1, String date2) {
	 return demandeVirementBancaireDAO.getDemandesInterByDate(date1, date2);
 }
 
 @Transactional
 public List getDemandesInterByDestinataire(String RIBdestinataire) {
	 return demandeVirementBancaireDAO.getDemandesInterByDestinataire(RIBdestinataire);
 }
 
 @Transactional
 public List getDemandesInterByExpediteur(String RIBexpediteur) {
	 return demandeVirementBancaireDAO.getDemandesInterByExpediteur(RIBexpediteur);
 }
 
 @Transactional
 public List getDemandesInterByBanque(String banqueDestinataire) {
	 return demandeVirementBancaireDAO.getDemandesInterByBanque(banqueDestinataire);
 }
 
 @Transactional
 public void updateStatut(int idDemandeVirementBancaire, String newStatut) {
	 demandeVirementBancaireDAO.updateStatut(idDemandeVirementBancaire, newStatut);
 }
 
 @Transactional
 public List getAllDemandeVirementBancaires() {
  return demandeVirementBancaireDAO.getAllDemandeVirementBancaires();
 }
 
 @Transactional
 public DemandeVirementBancaire getDemandeVirementBancaire(int idDemandeVirementBancaire) {
  return demandeVirementBancaireDAO.getDemandeVirementBancaire(idDemandeVirementBancaire);
 }
 
 @Transactional
 public void addDemandeVirementBancaire(DemandeVirementBancaire demandeVirementBancaire) {
  demandeVirementBancaireDAO.addDemandeVirementBancaire(demandeVirementBancaire);
 }
 
 @Transactional
 public void updateDemandeVirementBancaire(DemandeVirementBancaire demandeVirementBancaire) {
  demandeVirementBancaireDAO.updateDemandeVirementBancaire(demandeVirementBancaire);
 
 }
 
 @Transactional
 public void deleteDemandeVirementBancaire(int idDemandeVirementBancaire) {
  demandeVirementBancaireDAO.deleteDemandeVirementBancaire(idDemandeVirementBancaire);
 }
}