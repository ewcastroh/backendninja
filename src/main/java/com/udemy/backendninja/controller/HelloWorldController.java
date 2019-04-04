package com.udemy.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Controller
@RequestMapping("/say")
public class HelloWorldController {
	
	public static final String HELLO_WORLD_VIEW = "helloworld";

	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	// Inyección de componente que se encuentra en memoria
	@Autowired
	// Nombre del Bean que se encuentra en memoria
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	/*
	 * Primera forma de retornar una vista.
	 * Se debe retornar el nombre de la vista.
	 * No es necesario agregar el .html
	 */
	// Método para obtener una sola persona
	/*
	 * @RequestMapping(value = "/helloworld", method = RequestMethod.GET) public
	 * String helloWorld(Model model) { model.addAttribute("person", new
	 * Person("Eimer", 18)); return HELLO_WORLD_VIEW; }
	 */
	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	public String helloWorld(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", exampleService.getListPeople());
		return HELLO_WORLD_VIEW;
	}
	/*
	 * Una variación es no usando @RequestMapping,
	 * sino @GetMapping(De preferencia) 
	 */
	/*
	 * @GetMapping("/helloworld") public String helloWorld() { return "helloworld";
	 * }
	 */
	
	/*
	 * Segunda forma de retornar una vista.
	 * Se debe retornar un objeto ModelAndView
	 * enviando como parámetro el nombre de la vista.
	 */
	// Método para obtener una sola persona
	/*
	 * @GetMapping("/helloworldMAV") public ModelAndView helloWorldMAV() {
	 * ModelAndView mav = new ModelAndView(HELLO_WORLD_VIEW);
	 * mav.addObject("person", new Person("Wilfer", 28)); return mav; }
	 */

	// Método para obtener un listado de personas
	@GetMapping("/helloworldMAV")
	public ModelAndView helloWorldMAV() {
		ModelAndView mav = new ModelAndView(HELLO_WORLD_VIEW);
		mav.addObject("people", exampleService.getListPeople());
		return mav;
	}
	
}
