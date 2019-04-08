 package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.backendninja.constant.ViewConstant;

@Controller
public class LoginController {
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	/*
	 * @GetMapping("/") public String redirectToLogin() {
	 * LOG.info("METHOD: redirectToLogin()"); return "redirect:/login"; }
	 */
	
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOG.info("METHOD: showLoginForm() -- PARAMS: error:" + error + " - logout:" + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		/* model.addAttribute("userCredential", new UserCredential()); */
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}
	
	/*
	 * @PostMapping("/logincheck") public String logincCheck(@ModelAttribute(name =
	 * "userCredentials") UserCredential userCredential) {
	 * LOG.info("METHOD: logincCheck() -- PARAMS: userCredential:" +
	 * userCredential.toString()); if (userCredential.getUsername().equals("user")
	 * && userCredential.getPassword().equals("user")) {
	 * LOG.info("Returning to contacts view"); return
	 * "redirect:/contacts/showcontacts"; }
	 * LOG.info("Returning to login?error view"); return "redirect:/login?error"; }
	 */
	
	@GetMapping({"/loginsuccess", "/"})
	public String logincCheck() {
		LOG.info("METHOD: logincCheck()");
		LOG.info("Returning to contacts view");
		return "redirect:/contacts/showcontacts";
	}
}
