package org.missaoui.test.controller;

import java.util.Date;
import java.util.List;
import org.missaoui.test.model.DemandeVirementBancaire;
import org.missaoui.test.service.AbonneService;
import org.missaoui.test.service.DemandeVirementBancaireService;
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
public class DemandeVirementBancaireController {

	@Autowired
	DemandeVirementBancaireService demandeVirementBancaireService;
	@Autowired
	AbonneService abonneService;

	 @RequestMapping(value = "/admin/updateStatut/{idDemandeVirementBancaire}&{newStatut}", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateStatut(@PathVariable("idDemandeVirementBancaire") int idDemandeVirementBancaire, @PathVariable("newStatut") String newStatut) {  
		 demandeVirementBancaireService.updateStatut(idDemandeVirementBancaire, newStatut);
	 }
	 
	 @RequestMapping(value = "/admin/getDemandesByDate/{date1}&{date2}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getDemandesInterByDate(@PathVariable("date1") String date1, @PathVariable("date2") String date2) {  
	  List demandeVirementBancaires = demandeVirementBancaireService.getDemandesInterByDate(date1, date2);
	  return demandeVirementBancaires;
	 }

	 @RequestMapping(value = "/admin/getDemandesByDestinataire/{RIBdestinataire}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getDemandesInterByDestinataire(@PathVariable("RIBdestinataire") String RIBdestinataire) {  
	  List demandeVirementBancaires = demandeVirementBancaireService.getDemandesInterByDestinataire(RIBdestinataire);
	  return demandeVirementBancaires;
	 }
	 
	 @RequestMapping(value = "/admin/getDemandesByExpediteur/{RIBexpediteur}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getDemandesInterByExpediteur(@PathVariable("RIBexpediteur") String RIBexpediteur) {  
	  List demandeVirementBancaires = demandeVirementBancaireService.getDemandesInterByExpediteur(RIBexpediteur);
	  return demandeVirementBancaires;
	 }
	 
	 @RequestMapping(value = "/admin/getDemandesByBanque/{banqueDestinataire}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getDemandesInterByBanque(@PathVariable("banqueDestinataire") String banqueDestinataire) {  
	  List demandeVirementBancaires = demandeVirementBancaireService.getDemandesInterByBanque(banqueDestinataire);
	  return demandeVirementBancaires;
	 }
	 
	 @RequestMapping(value = "/admin/getAllDemandeVirementBancaires", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getDemandeVirementBancaires() {  
	  List demandeVirementBancaires = demandeVirementBancaireService.getAllDemandeVirementBancaires();
	  return demandeVirementBancaires;
	 }
	 
	 @RequestMapping(value = "/admin/getDemandeVirementBancaire/{idDemandeVirementBancaire}", headers = "Accept=application/json")
	 public DemandeVirementBancaire getDemandeVirementBancaire(@PathVariable("idDemandeVirementBancaire") int idDemandeVirementBancaire) {
	  return demandeVirementBancaireService.getDemandeVirementBancaire(idDemandeVirementBancaire);
	 }
	 
	 @RequestMapping(value = "/abonne/addDemandeVirementBancaire/{type}", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addDemandeVirementBancaire(@RequestBody DemandeVirementBancaire demandeVirementBancaire, @PathVariable("type") String type) { 
		 demandeVirementBancaire.setTypeVirement(type);
		 demandeVirementBancaire.setStatut("non confirme");
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  User user = (User)authentication.getPrincipal();
		  String idClient = abonneService.getIdClientByCodeAbonne(user.getUsername());
		  demandeVirementBancaire.setAbonne(abonneService.getAbonne(idClient));
		  demandeVirementBancaire.setDateVirement(new Date());
		 demandeVirementBancaireService.addDemandeVirementBancaire(demandeVirementBancaire);
	  
	 }
	 
	 @RequestMapping(value = "/admin/updateDemandeVirementBancaire", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateDemandeVirementBancaire(@RequestBody DemandeVirementBancaire demandeVirementBancaire) {
	  demandeVirementBancaireService.updateDemandeVirementBancaire(demandeVirementBancaire);
	 }
	 
	 @RequestMapping(value = "/admin/deleteDemandeVirementBancaire/{idDemandeVirementBancaire}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteDemandeVirementBancaire(@PathVariable("idDemandeVirementBancaire") int idDemandeVirementBancaire) {
	  demandeVirementBancaireService.deleteDemandeVirementBancaire(idDemandeVirementBancaire);  
	 } 
}
