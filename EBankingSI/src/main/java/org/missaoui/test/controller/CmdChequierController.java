package org.missaoui.test.controller;

import java.util.List;
import org.missaoui.test.model.CmdChequier;
import org.missaoui.test.service.CmdChequierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/rest")
public class CmdChequierController {

	@Autowired
	CmdChequierService cmdChequierService;
	
	 @RequestMapping(value = "/updateStatutCmdChequier/{idCmdChequier}&{newStatut}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public void updateStatutCmdChequier(@PathVariable("idCmdChequier") int idCmdChequier, @PathVariable("newStatut") String newStatut) {  
	  cmdChequierService.updateStatutCmdChequier(idCmdChequier, newStatut);
	 }
	 
	 @RequestMapping(value = "/getCmdsChequierByClient/{idClient}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getCmdsChequierByClient(@PathVariable("idClient") String idClient) {  
	  List cmdsChequier = cmdChequierService.getCmdsChequierByClient(idClient);
	  return cmdsChequier;
	 }
	 
	 @RequestMapping(value = "/getCmdsChequierByNumeroCompte/{numeroCompte}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getCmdsChequierByNumeroCompte(@PathVariable("numeroCompte") String numeroCompte) {  
	  List cmdsChequier = cmdChequierService.getCmdsChequierByNumeroCompte(numeroCompte);
	  return cmdsChequier;
	 }
	 
	 @RequestMapping(value = "/getAllCmdsChequier", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getCmdsChequier() {  
	  List cmdsChequier = cmdChequierService.getAllCmdsChequier();
	  return cmdsChequier;
	 }
	 
	 @RequestMapping(value = "/getCmdChequier/{idCmdChequier}", headers = "Accept=application/json")
	 public CmdChequier getCmdChequier(@PathVariable("idCmdChequier") int idCmdChequier) {
	  return cmdChequierService.getCmdChequier(idCmdChequier);
	 }
	 
	 @RequestMapping(value = "/addCmdChequier", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addCmdChequier(@RequestBody CmdChequier cmdChequier) { 
	  cmdChequierService.addCmdChequier(cmdChequier);
	  
	 }
	 
	 @RequestMapping(value = "/updateCmdChequier", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateCmdChequier(@RequestBody CmdChequier cmdChequier) {
	  cmdChequierService.updateCmdChequier(cmdChequier);
	 }
	 
	 @RequestMapping(value = "/deleteCmdChequier/{idCmdChequier}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteCmdChequier(@PathVariable("idCmdChequier") int idCmdChequier) {
	  cmdChequierService.deleteCmdChequier(idCmdChequier);  
	 } 
}
