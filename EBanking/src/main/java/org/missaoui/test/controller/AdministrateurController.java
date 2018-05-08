package org.missaoui.test.controller;

import java.util.List;

import org.missaoui.test.model.Abonne;
import org.missaoui.test.model.Administrateur;
import org.missaoui.test.service.AbonneService;
import org.missaoui.test.service.AdministrateurService;
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
@RequestMapping("/admin")
public class AdministrateurController {

	@Autowired
	AdministrateurService administrateurService;
	
	@Autowired
	AbonneService abonneService;
	
	@RequestMapping(value = "/createAbonneByAdministrateur", method = RequestMethod.POST, headers = "Accept=application/json")
	public void createAbonneByAdministrateur(@RequestBody Abonne abonne)
	{
		abonneService.addAbonne(abonne);
	}
	
	 @RequestMapping(value = "/updatePasswordAdmin/{newPassword}&{oldPassword}", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public boolean updatePasswordAdmin(@PathVariable("newPassword") String newPassword, @PathVariable("oldPassword") String oldPassword) { 
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 User user = (User)authentication.getPrincipal();
		 String idAdministrateur = administrateurService.getIdAdministrateurByUsername(user.getUsername());
		 Boolean bool = administrateurService.verifPassword(idAdministrateur, oldPassword);
		 if(bool)
		 {
			 administrateurService.updatePassword(idAdministrateur, newPassword);
			 return true;
		 }
		 return false; 
	 }
	
	 @RequestMapping(value = "/deleteAbonneByAdministrateur/{idClient}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteAbonneByAdministrateur(@PathVariable("idClient") String idClient) {
	  abonneService.deleteAbonne(idClient);  
	 } 
	
	 @RequestMapping(value = "/getAllAdministrateurs", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getAdministrateurs() {  
	  List administrateurs = administrateurService.getAllAdministrateurs();
	  return administrateurs;
	 }
	 
	 @RequestMapping(value = "/getAdministrateur/{idAdministrateur}", headers = "Accept=application/json")
	 public Administrateur getAdministrateur(@PathVariable("idAdministrateur") String idAdministrateur) {
	  return administrateurService.getAdministrateur(idAdministrateur);
	 }
	 
	 @RequestMapping(value = "/addAdministrateur", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addAdministrateur(@RequestBody Administrateur administrateur) { 
	  administrateurService.addAdministrateur(administrateur);
	  
	 }
	 
	 @RequestMapping(value = "/updateAdministrateur", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateAdministrateur(@RequestBody Administrateur administrateur) {
	  administrateurService.updateAdministrateur(administrateur);
	 }
	 
	 @RequestMapping(value = "/deleteAdministrateur/{idAdministrateur}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteAdministrateur(@PathVariable("idAdministrateur") String idAdministrateur) {
	  administrateurService.deleteAdministrateur(idAdministrateur);  
	 } 
}
