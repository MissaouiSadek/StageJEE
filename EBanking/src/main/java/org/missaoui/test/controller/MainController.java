package org.missaoui.test.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.missaoui.test.dao.AbonneUserDAO;
import org.missaoui.test.dao.AdministrateurUserDAO;
import org.missaoui.test.model.Abonne;
import org.missaoui.test.service.AbonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@Autowired
	AbonneService abonneService;
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;

	}
	
	@RequestMapping(value = "/index/admin/getAbonnesPage", method = RequestMethod.GET)
	public ModelAndView getAbonnesPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("getAbonnesPage");

		return model;

	}
	
	@RequestMapping(value = "/paginationTemplate", method = RequestMethod.GET)
	public ModelAndView paginationTemplate() {

		ModelAndView model = new ModelAndView();
		model.setViewName("paginationTemplate");

		return model;

	}
	
	@RequestMapping(value = "/index/admin/getVirementsPage", method = RequestMethod.GET)
	public ModelAndView getVirementsPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("getVirementsPage");

		return model;

	}
	
	@RequestMapping(value = "/index/admin/ajoutBeneficiairesPage", method = RequestMethod.GET)
	public ModelAndView ajoutBeneficiairePage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ajoutBeneficiairesPage");

		return model;

	}
	
	@RequestMapping(value = "/admin/updatePasswordAdminPage", method = RequestMethod.GET)
	public ModelAndView updatePasswordAdminPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("updatePasswordAdminPage");

		return model;

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin");

		return model;

	}
	
	@RequestMapping(value = "/abonne/updateClientPage", method = RequestMethod.GET)
	public ModelAndView updateClientPage() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String idClient = abonneService.getIdClientByCodeAbonne(user.getUsername());
		ModelAndView model = new ModelAndView();	
		model.addObject("idClient",idClient);
		model.setViewName("updateClientPage");

		return model;

	}
	
	@RequestMapping(value = "/index/introduction", method = RequestMethod.GET)
	public ModelAndView introductionPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("introduction");

		return model;

	}
	
	@RequestMapping(value = "/verif", method = RequestMethod.GET)
	public ModelAndView verifPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("verif");

		return model;

	}
	
	@RequestMapping(value = "/verifCode", method = RequestMethod.GET)
	public ModelAndView verifCodePage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("verifCode");

		return model;

	}
	
	@RequestMapping(value = "/index/abonne/getComptesPage", method = RequestMethod.GET)
	public ModelAndView comptesPage() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String idClient = abonneService.getIdClientByCodeAbonne(user.getUsername());
		ModelAndView model = new ModelAndView();	
		model.addObject("idClient",idClient);
		model.setViewName("getComptesPage");

		return model;

	}
	
	@RequestMapping(value = "/index/abonne/getCmdChequierPage", method = RequestMethod.GET)
	public ModelAndView getCmdChequierPage() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String idClient = abonneService.getIdClientByCodeAbonne(user.getUsername());
		ModelAndView model = new ModelAndView();	
		model.addObject("idClient",idClient);
		model.setViewName("getCmdChequierPage");

		return model;

	}
	
	@RequestMapping(value = "/index/abonne/getListeCmdChequierPage", method = RequestMethod.GET)
	public ModelAndView getListeCmdChequierPage() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String idClient = abonneService.getIdClientByCodeAbonne(user.getUsername());
		ModelAndView model = new ModelAndView();	
		model.addObject("idClient",idClient);
		model.setViewName("getListeCmdChequierPage");

		return model;

	}
	
	@RequestMapping(value = "/index/abonne/getCmdCartePage", method = RequestMethod.GET)
	public ModelAndView getCmdCartePage() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String idClient = abonneService.getIdClientByCodeAbonne(user.getUsername());
		ModelAndView model = new ModelAndView();	
		model.addObject("idClient",idClient);
		model.setViewName("getCmdCartePage");

		return model;

	}
	
	@RequestMapping(value = "/index/abonne/getListeCmdCartePage", method = RequestMethod.GET)
	public ModelAndView getListeCmdCartePage() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String idClient = abonneService.getIdClientByCodeAbonne(user.getUsername());
		ModelAndView model = new ModelAndView();	
		model.addObject("idClient",idClient);
		model.setViewName("getListeCmdCartePage");

		return model;

	}
	
	@RequestMapping(value = "/index/abonne/getBeneficiairesPage", method = RequestMethod.GET)
	public ModelAndView getBenefciairesPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("getBeneficiairesPage");

		return model;

	}
	
	@RequestMapping(value = "/abonne/updatePasswordPage", method = RequestMethod.GET)
	public ModelAndView updatePasswordPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("updatePasswordPage");

		return model;

	}
	
	@RequestMapping(value = "/index/abonne/setVirementIntraPage", method = RequestMethod.GET)
	public ModelAndView setVirementIntraPage() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String idClient = abonneService.getIdClientByCodeAbonne(user.getUsername());
		ModelAndView model = new ModelAndView();	
		model.addObject("idClient",idClient);
		model.setViewName("setVirementIntraPage");

		return model;

	}
	
	@RequestMapping(value = "/index/abonne/getOperationsPage", method = RequestMethod.GET)
	public ModelAndView getOperationsPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("getOperationsPage");
		return model;

	}
	
	@RequestMapping(value = "/index/abonne/setVirementInterPage", method = RequestMethod.GET)
	public ModelAndView setVirementInterPage() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String idClient = abonneService.getIdClientByCodeAbonne(user.getUsername());
		ModelAndView model = new ModelAndView();	
		model.addObject("idClient",idClient);
		model.setViewName("setVirementInterPage");

		return model;

	}
	
	@RequestMapping(value = "/abonne", method = RequestMethod.GET)
	public ModelAndView abonnePage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("abonne");

		return model;

	}

}