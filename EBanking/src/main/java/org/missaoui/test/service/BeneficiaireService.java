package org.missaoui.test.service;

import java.util.List;
import org.missaoui.test.dao.BeneficiaireDAO;
import org.missaoui.test.model.Beneficiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service("beneficiaireService")
public class BeneficiaireService {
 
 @Autowired
 BeneficiaireDAO beneficiaireDAO;
 
 @Transactional
 public void updateStatutBeneficiaire (String idBeneficiaire, String newStatut) {
	 beneficiaireDAO.updateStatutBeneficiaire(idBeneficiaire, newStatut);
 }
 
 @Transactional
 public String getCodeValidation(String idBeneficiaire)
 {
	 return beneficiaireDAO.getCodeValidation(idBeneficiaire);
 }
 
 @Transactional
 public void setCodeValidation(String idBeneficiaire, String email)
 {
	 beneficiaireDAO.setCodeValidation(idBeneficiaire, email);
 }
 
 @Transactional
 public List getBeneficiairesByStatut(String statut)
 {
	 return beneficiaireDAO.getBeneficiairesByStatut(statut);
 }
 
 @Transactional
 public List getBeneficiairesValidesByAbonne(String idClient)
 {
	 return beneficiaireDAO.getBeneficiairesValidesByAbonne(idClient);
 }
 
 @Transactional
 public List getBeneficiairesByAbonne(String idClient)
 {
	 return beneficiaireDAO.getBeneficiairesByAbonne(idClient);
 }
 
 @Transactional
 public Beneficiaire getBeneficiaireByNumeroCompte(String numeroCompte) {
	 return beneficiaireDAO.getBeneficiaireByNumeroCompte(numeroCompte);
 }
 
 @Transactional
 public List getAllBeneficiaires() {
  return beneficiaireDAO.getAllBeneficiaires();
 }
 
 @Transactional
 public Beneficiaire getBeneficiaire(String idBeneficiaire) {
  return beneficiaireDAO.getBeneficiaire(idBeneficiaire);
 }
 
 @Transactional
 public void addBeneficiaire(Beneficiaire beneficiaire) {
  beneficiaireDAO.addBeneficiaire(beneficiaire);
 }
 
 @Transactional
 public void updateBeneficiaire(Beneficiaire beneficiaire) {
  beneficiaireDAO.updateBeneficiaire(beneficiaire);
 
 }
 
 @Transactional
 public void deleteBeneficiaire(String idBeneficiaire) {
  beneficiaireDAO.deleteBeneficiaire(idBeneficiaire);
 }
}