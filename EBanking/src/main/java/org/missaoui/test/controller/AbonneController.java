package org.missaoui.test.controller;

import java.util.Date;
import java.util.List;
import org.missaoui.test.model.Abonne;
import org.missaoui.test.service.AbonneService;
import org.missaoui.test.service.BeneficiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
public class AbonneController {
	
	@Autowired
	AbonneService abonneService;
	@Autowired
	BeneficiaireService beneficiaireService;
	 
	 @RequestMapping(value = "/admin/getAllAbonnes", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getAbonnes() {  
	  List abonnes = abonneService.getAllAbonnes();
	  return abonnes;
	 }
	 
	 @RequestMapping(value = "/abonne/getBeneficiairesValidesByAbonne", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getBeneficiairesValidesByAbonne() { 
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  User user = (User)authentication.getPrincipal();
		  String idClient = abonneService.getIdClientByCodeAbonne(user.getUsername());
		 return beneficiaireService.getBeneficiairesValidesByAbonne(idClient);
	 }
	 
	 @RequestMapping(value = "/admin/getBeneficiairesByAbonne/{idClient}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getBeneficiairesByAbonne(@PathVariable("idClient") String idClient) { 
		 return beneficiaireService.getBeneficiairesByAbonne(idClient);
	 }
	 
	 @RequestMapping(value = "/admin/getAbonnesByDateCreation/{date1}&{date2}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getAbonnesByDateCreation(@PathVariable("date1") String date1, @PathVariable("date2") String date2) {  
		 List abonnes = abonneService.getAbonnesByDateCreation(date1, date2);
	  return abonnes;
	 }
	 
	 @RequestMapping(value = "/abonne/verifPassword/{password}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public boolean verifPassword(@PathVariable("password") String password) {  
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 User user = (User)authentication.getPrincipal();
		 String idClient = abonneService.getIdClientByCodeAbonne(user.getUsername());
		 boolean bool = abonneService.verifPassword(idClient, password);
		 return bool;
	 }
	 
	 @RequestMapping(value = "/abonne/updatePasswordAbonne/{newPassword}&{oldPassword}", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public Boolean updatePasswordAbonne(@PathVariable("newPassword") String newPassword, @PathVariable("oldPassword") String oldPassword) {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 User user = (User)authentication.getPrincipal();
		 String idClient = abonneService.getIdClientByCodeAbonne(user.getUsername());
		 Boolean bool = abonneService.verifPassword(idClient, oldPassword);
		 if(bool)
		 {
			 abonneService.updatePasswordAbonne(idClient, newPassword);
			 return true;
		 }
		 return false; 
	 }
	 
	 @RequestMapping(value = "/admin/getAbonne/{idClient}", headers = "Accept=application/json")
	 public Abonne getAbonne(@PathVariable("idClient") String idClient) {
	  return abonneService.getAbonne(idClient);
	 }
	 
	 @RequestMapping(value = "/admin/addAbonne", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addAbonne(@RequestBody Abonne abonne) { 
	  abonneService.addAbonne(abonne);
	  
	 }
	 
	 @RequestMapping(value = "/admin/updateAbonne", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateAbonne(@RequestBody Abonne abonne) {
	  abonneService.updateAbonne(abonne);
	 }
	 
	 @RequestMapping(value = "/admin/deleteAbonne/{idClient}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteAbonne(@PathVariable("idClient") String idClient) {
	  abonneService.deleteAbonne(idClient);  
	 } 
}
