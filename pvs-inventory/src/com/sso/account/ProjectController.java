package com.sso.account;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({"user"})
public class ProjectController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	
	public String printMessage(ModelMap model, Principal principal) {

		String username = principal.getName();
		model.addAttribute("user", username);
		
		//model.addAttribute("msg", "Spring Security Customized Login from Database Table");
		//return "naturovedadashboardhf";
		return "forward:/ClientAddressServlet";
		

	}
		
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		//System.out.println("Avijit-zilaxo");
		return "login";

	}

	@RequestMapping(value = "/failLogin", method = RequestMethod.GET)
	public String failedLogin(ModelMap model) {
		
		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logoff", method = RequestMethod.GET)
	public String logoff(ModelMap model) {

		return "login";

	}
}
