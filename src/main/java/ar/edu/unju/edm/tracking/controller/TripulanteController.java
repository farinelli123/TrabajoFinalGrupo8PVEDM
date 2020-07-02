package ar.edu.unju.edm.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.tracking.Service.ITripulanteService;
import ar.edu.unju.edm.tracking.modelo.Tripulante;

@Controller
@RequestMapping
public class TripulanteController {
	
	@Autowired
	ITripulanteService tripulanteService;

	@GetMapping("/nuevoTripulante")
	public String agregarTripulante(Model model) {
		model.addAttribute("tripulanteD", new Tripulante());
		return "tripulante";
	}

	@PostMapping("/saveTripulante")
	public String guardarTripulante(@ModelAttribute Tripulante tripulante, Model model) {
		tripulanteService.guardarTripulante(tripulante);
		return "redirect:/nuevoTripulante";
	}
}
