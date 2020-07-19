package ar.edu.unju.edm.tracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {
	@GetMapping({"/","/login"})
	public String ingresar(Model model) {
		return "login";
	}
	@GetMapping("/indexBD")
	public String ingresarbd (Model model) {
		return "indexBD";
	}
	@GetMapping("/indexConsultor")
	public String ingresarconsultor (Model model) {
		return "indexConsultor";
	}
	@GetMapping("/indexRegistrador")
	public String ingresaregistrador (Model model) {
		return "indexRegistrador";
	}
	@GetMapping("/consultaPatente")
	public String ingresarConsultaPatente (Model model) {
		return "ConsultaPatente";	
	}
	@GetMapping("/consultaTripulante")
	public String ingresarConsultatripulante (Model model) {
		return "ConsultaTripulante";	
	}
	@GetMapping("/error")
	public String errar(Model model) {
		return "error";
	}
}
