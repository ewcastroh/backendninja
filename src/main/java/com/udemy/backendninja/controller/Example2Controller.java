package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {

	private static final String EXAMPLE2_VIEW = "example2";

	/*
	 * Enviando parámetros
	 * Forma1
	 * localhost:8080/example2/request1?nm=Eimer
	 * localhost:8080/example2/request1?nm=Wilfer
	 */
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name = "nm", required = false, defaultValue = "GUEST") String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
		mav.addObject("nm_in_model", name);
		return mav;
	}
	
	/*
	 * Enviando parámetros
	 * Forma2
	 * localhost:8080/example2/request2/Eimer
	 * localhost:8080/example2/request2/Wilfer
	 */
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable(name = "nm") String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
		mav.addObject("nm_in_model", name);
		return mav;
	}
}
