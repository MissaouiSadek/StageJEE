package org.missaoui.test.service;

import java.util.List;
import org.missaoui.test.dao.CmdCarteDAO;
import org.missaoui.test.model.CmdCarte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service("cmdCarteService")
public class CmdCarteService {
 
 @Autowired
 CmdCarteDAO cmdCarteDAO;
 
 @Transactional
 public List getAllCmdsCarte() {
  return cmdCarteDAO.getAllCmdsCarte();
 }
 
 @Transactional
 public List getCmdsCarteByClient(String idClient)
 {
	 return cmdCarteDAO.getCmdsCarteByClient(idClient);
 }
 
 @Transactional
 public List getCmdsCarteByNumeroCompte(String numeroCompte)
 {
	 return cmdCarteDAO.getCmdsCarteByNumeroCompte(numeroCompte);
 }
 
 @Transactional
 public CmdCarte getCmdCarte(int idCmdCarte) {
  return cmdCarteDAO.getCmdCarte(idCmdCarte);
 }
 
 @Transactional
 public void addCmdCarte(CmdCarte cmdCarte) {
  cmdCarteDAO.addCmdCarte(cmdCarte);
 }
 
 @Transactional
 public void updateStatutCmdCarte(int idCmdCarte, String newStatut) {
  cmdCarteDAO.updateStatutCmdCarte(idCmdCarte, newStatut);
 }
 
 @Transactional
 public void updateCmdCarte(CmdCarte cmdCarte) {
  cmdCarteDAO.updateCmdCarte(cmdCarte);
 
 }
 
 @Transactional
 public void deleteCmdCarte(int idCmdCarte) {
  cmdCarteDAO.deleteCmdCarte(idCmdCarte);
 }
}
