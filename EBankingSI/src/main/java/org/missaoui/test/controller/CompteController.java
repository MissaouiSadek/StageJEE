package org.missaoui.test.controller;

import java.util.List;
import org.missaoui.test.model.Compte;
import org.missaoui.test.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/rest")
public class CompteController {

	@Autowired
	CompteService compteService;
	 
	 @RequestMapping(value = "/getAllComptes", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getComptes() {  
	  List comptes = compteService.getAllComptes();
	  return comptes;
	 }
	 
	 @RequestMapping(value = "/getComptesByIdClient/{idClient}", headers = "Accept=application/json")
	 public List getComptesByIdClient(@PathVariable("idClient") String idClient) {
	  return compteService.getComptesByIdClient(idClient);
	 }
	 
	 @RequestMapping(value = "/getCompte/{RIB}", headers = "Accept=application/json")
	 public Compte getCompte(@PathVariable("RIB") String RIB) {
	  return compteService.getCompte(RIB);
	 }
	 
	 @RequestMapping(value = "/addCompte", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addCompte(@RequestBody Compte compte) { 
	  compteService.addCompte(compte);
	  
	 }
	 
	 @RequestMapping(value = "/updateCompte", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateCompte(@RequestBody Compte compte) {
	  compteService.updateCompte(compte);
	 }
	 
	 @RequestMapping(value = "/deleteCompte/{RIB}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteCompte(@PathVariable("RIB") String RIB) {
	  compteService.deleteCompte(RIB);  
	 } 
}
