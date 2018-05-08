package org.missaoui.test.service;

import java.util.List;
import org.missaoui.test.dao.OperationDAO;
import org.missaoui.test.model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service("operationService")
public class OperationService {
 
 @Autowired
 OperationDAO operationDAO;
 
 @Transactional
 public List getAllOperations() {
  return operationDAO.getAllOperations();
 }
 
 @Transactional
 public List getOperationsByDate(String numeroCompte, String date1, String date2) {
  return operationDAO.getOperationsByDate(numeroCompte,date1, date2);
 }
 
 @Transactional
 public List getOperationsByNumeroCompte(String numeroCompte) {
  return operationDAO.getOperationsByNumeroCompte(numeroCompte);
 }
 
 @Transactional
 public Operation getOperation(int idOperation) {
  return operationDAO.getOperation(idOperation);
 }
 
 @Transactional
 public void addOperation(Operation operation) {
  operationDAO.addOperation(operation);
 }
 
 @Transactional
 public void updateOperation(Operation operation) {
  operationDAO.updateOperation(operation);
 
 }
 
 @Transactional
 public void deleteOperation(int idOperation) {
  operationDAO.deleteOperation(idOperation);
 }
}