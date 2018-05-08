package org.missaoui.test.controller;

import java.util.Date;
import java.util.List;
import org.missaoui.test.model.Operation;
import org.missaoui.test.service.OperationService;
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
@RequestMapping("/rest")
public class OperationController {

	@Autowired
	OperationService operationService;
	 
	 @RequestMapping(value = "/getOperationsByDate/{numeroCompte}/{date1}&{date2}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getOperationsByDate(@PathVariable("numeroCompte") String numeroCompte, @PathVariable("date1") String date1, @PathVariable("date2") String date2) {  
	  List operations = operationService.getOperationsByDate(numeroCompte, date1, date2);
	  return operations;
	 }
	 
	 @RequestMapping(value = "/getOperationsByNumeroCompte/{numeroCompte}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getOperationsByNumeroCompte(@PathVariable("numeroCompte") String numeroCompte) {  
	  List operations = operationService.getOperationsByNumeroCompte(numeroCompte);
	  return operations;
	 }
	 
	 @RequestMapping(value = "/getAllOperations", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List getOperations() {  
	  List operations = operationService.getAllOperations();
	  return operations;
	 }
	 
	 @RequestMapping(value = "/getOperation/{idOperation}", headers = "Accept=application/json")
	 public Operation getOperation(@PathVariable("idOperation") int idOperation) {
	  return operationService.getOperation(idOperation);
	 }
	 
	 @RequestMapping(value = "/addOperation", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addOperation(@RequestBody Operation operation) { 
		 operation.setDateOperation(new Date());
		 operationService.addOperation(operation);
	  
	 }
	 
	 @RequestMapping(value = "/updateOperation", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateOperation(@RequestBody Operation operation) {
	  operationService.updateOperation(operation);
	 }
	 
	 @RequestMapping(value = "/deleteOperation/{idOperation}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteOperation(@PathVariable("idOperation") int idOperation) {
	  operationService.deleteOperation(idOperation);  
	 } 
}
