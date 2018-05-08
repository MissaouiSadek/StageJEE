package org.missaoui.test.controller;

import java.util.List;
import org.missaoui.test.model.CmdCarte;
import org.missaoui.test.service.CmdCarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/rest")
public class CmdCarteController {

	@Autowired
	CmdCarteService cmdCarteService;
	
	 @RequestMapping(value = "/updateStatutCmdCarte/{idCmdCarte}&{newStatut}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public void updateStatutCmdCarte(@PathVariable("idCmdCarte") int idCmdCarte, @PathVariable("newStatut") String newStatut) {  
	  cmdCarteService.updateStatutCmdCarte(idCmdCarte, newStatut);
	 }
	 
	 @RequestMapping(value = "/getCmdsCarteByClient/{idClient}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getCmdsCarteByClient(@PathVariable("idClient") String idClient) {  
	  List cmdsCarte = cmdCarteService.getCmdsCarteByClient(idClient);
	  return cmdsCarte;
	 }
	 
	 @RequestMapping(value = "/getCmdsCarteByNumeroCompte/{numeroCompte}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getCmdsCarteByNumeroCompte(@PathVariable("numeroCompte") String numeroCompte) {  
	  List cmdsCarte = cmdCarteService.getCmdsCarteByNumeroCompte(numeroCompte);
	  return cmdsCarte;
	 }
	 
	 @RequestMapping(value = "/getAllCmdsCarte", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getCmdsCarte() {  
	  List cmdsCarte = cmdCarteService.getAllCmdsCarte();
	  return cmdsCarte;
	 }
	 
	 @RequestMapping(value = "/getCmdCarte/{idCmdCarte}", headers = "Accept=application/json")
	 public CmdCarte getCmdCarte(@PathVariable("idCmdCarte") int idCmdCarte) {
	  return cmdCarteService.getCmdCarte(idCmdCarte);
	 }
	 
	 @RequestMapping(value = "/addCmdCarte", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addCmdCarte(@RequestBody CmdCarte cmdCarte) { 
	  cmdCarteService.addCmdCarte(cmdCarte);
	  
	 }
	 
	 @RequestMapping(value = "/updateCmdCarte", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateCmdCarte(@RequestBody CmdCarte cmdCarte) {
	  cmdCarteService.updateCmdCarte(cmdCarte);
	 }
	 
	 @RequestMapping(value = "/deleteCmdCarte/{idCmdCarte}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteCmdCarte(@PathVariable("idCmdCarte") int idCmdCarte) {
	  cmdCarteService.deleteCmdCarte(idCmdCarte);  
	 } 
}
