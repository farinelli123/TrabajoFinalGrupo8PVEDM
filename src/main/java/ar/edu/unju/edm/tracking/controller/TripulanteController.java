package ar.edu.unju.edm.tracking.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "FormTripulante";
	}

	@PostMapping("/saveTripulante")
	public String guardarTripulante(@Valid @ModelAttribute("tripulanteD") Tripulante tripulante, Model model) {
		System.out.println(tripulante.getApellido());
		tripulanteService.guardarTripulante(tripulante);
		return "redirect:/listarTripulante";
	}
	@GetMapping("/listarTripulante")
	public String listarTripulante(Model model) {
		model.addAttribute("tripulantes", tripulanteService.listar());
		return "VistaTripulante";
		/*Iterable<Tripulante>tripulante=tripulanteService.listar();
		model.addAttribute("tripulante", tripulante);
		return "VistaTripulante";*/
	} 
	@GetMapping("/deleteTripulante/{id}")
	public String eliminar(@PathVariable int id,Model model) {
		tripulanteService.delete(id);
		return "redirect:/listarTripulante";
	}
	@GetMapping("/editarTripulante/{id}")
	public String editarTripulante(@PathVariable int id, Model model) {
		Optional<Tripulante> tripulante=tripulanteService.listarId(id);
		model.addAttribute("tripulanteD", tripulante);
		return "FormTripulante";
	}
}
