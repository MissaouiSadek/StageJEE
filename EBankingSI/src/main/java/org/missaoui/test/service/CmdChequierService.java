package org.missaoui.test.service;

import java.util.List;
import org.missaoui.test.dao.CmdChequierDAO;
import org.missaoui.test.model.CmdChequier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service("cmdChequierService")
public class CmdChequierService {
 
 @Autowired
 CmdChequierDAO cmdChequierDAO;
 
 @Transactional
 public List getAllCmdsChequier() {
  return cmdChequierDAO.getAllCmdsChequier();
 }
 
 @Transactional
 public List getCmdsChequierByClient(String idClient)
 {
	 return cmdChequierDAO.getCmdsChequierByClient(idClient);
 }
 
 @Transactional
 public List getCmdsChequierByNumeroCompte(String numeroCompte)
 {
	 return cmdChequierDAO.getCmdsChequierByNumeroCompte(numeroCompte);
 }
 
 @Transactional
 public CmdChequier getCmdChequier(int idCmdChequier) {
  return cmdChequierDAO.getCmdChequier(idCmdChequier);
 }
 
 @Transactional
 public void addCmdChequier(CmdChequier cmdChequier) {
  cmdChequierDAO.addCmdChequier(cmdChequier);
 }
 
 @Transactional
 public void updateStatutCmdChequier(int idCmdChequier, String newStatut) {
  cmdChequierDAO.updateStatutCmdChequier(idCmdChequier, newStatut);
 }
 
 @Transactional
 public void updateCmdChequier(CmdChequier cmdChequier) {
  cmdChequierDAO.updateCmdChequier(cmdChequier);
 
 }
 
 @Transactional
 public void deleteCmdChequier(int idCmdChequier) {
  cmdChequierDAO.deleteCmdChequier(idCmdChequier);
 }
}