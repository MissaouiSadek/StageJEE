package org.missaoui.test.controller;

import java.util.List;
import org.missaoui.test.model.Beneficiaire;
import org.missaoui.test.service.AbonneService;
import org.missaoui.test.service.BeneficiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class BeneficiaireController {

	@Autowired
	BeneficiaireService beneficiaireService;
	@Autowired
	AbonneService abonneService;
	String benef="1234";
	 
	 @RequestMapping(value = "/admin/updateStatutBeneficiaire/{idBeneficiaire}&{newStatut}", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateStatutBeneficiaire(@PathVariable("idBeneficiaire") String idBeneficiaire, @PathVariable("newStatut") String newStatut) {  
		 beneficiaireService.updateStatutBeneficiaire(idBeneficiaire, newStatut);
	 }
	 
	 @RequestMapping(value = "/abonne/setCodeValidation/{idBeneficiaire}&{email1}/{email2}&{email3}", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void setCodeValidation(@PathVariable("idBeneficiaire") String idBeneficiaire,@PathVariable("email1") String email1, @PathVariable("email2") String email2, @PathVariable("email3") String email3) {
		 String email = email1+"@"+email2+"."+email3;
		 beneficiaireService.setCodeValidation(idBeneficiaire,email);
		 benef = beneficiaireService.getCodeValidation(idBeneficiaire);
	 }
	 
	 @RequestMapping(value = "/abonne/verifCodeValidation/{code}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public boolean getCodeValidation(@PathVariable("code") String code) {
		 if (benef.equals(code))
			 return true;
		 return false;
	 }
	 
	 @RequestMapping(value = "/abonne/getBeneficiairesByStatut/{statut}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getBeneficiairesByStatut(@PathVariable("statut") String statut) {  
		 return beneficiaireService.getBeneficiairesByStatut(statut);
	 }
	 
	 @RequestMapping(value = "/admin/getBeneficiaireByNumeroCompte/{numeroCompte}", headers = "Accept=application/json")
	 public Beneficiaire getBeneficiaireByNumeroCompte(@PathVariable("numeroCompte") String numeroCompte) {
	  return beneficiaireService.getBeneficiaireByNumeroCompte(numeroCompte);
	 }
	
	 @RequestMapping(value = "/admin/getAllBeneficiaires", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getBeneficiaires() {  
	  List beneficiaires = beneficiaireService.getAllBeneficiaires();
	  return beneficiaires;
	 }
	 
	 @RequestMapping(value = "/admin/getBeneficiaire/{idBeneficiaire}", headers = "Accept=application/json")
	 public Beneficiaire getBeneficiaire(@PathVariable("idBeneficiaire") String idBeneficiaire) {
	  return beneficiaireService.getBeneficiaire(idBeneficiaire);
	 }
	 
	 @RequestMapping(value = "/admin/addBeneficiaire", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addBeneficiaire(@RequestBody Beneficiaire beneficiaire) { 
	  beneficiaireService.addBeneficiaire(beneficiaire);
	  
	 }
	 
	 @RequestMapping(value = "/admin/updateBeneficiaire", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
	  beneficiaireService.updateBeneficiaire(beneficiaire);
	 }
	 
	 @RequestMapping(value = "/admin/deleteBeneficiaire/{idBeneficiaire}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteBeneficiaire(@PathVariable("idBeneficiaire") String idBeneficiaire) {
	  beneficiaireService.deleteBeneficiaire(idBeneficiaire);  
	 } 
}
