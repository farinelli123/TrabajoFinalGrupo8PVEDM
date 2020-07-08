package ar.edu.unju.edm.tracking.controller;

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
		if (!model.containsAttribute("tripulanteD")){
			model.addAttribute("tripulanteD", new Tripulante());
		}
		return "FormUsuario";
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
	public String editarTripulante(Model model, @PathVariable(name="id") Integer id) throws Exception {
		Tripulante tripulante1=tripulanteService.editar(id);
		System.out.println(tripulante1.getIdTripulante());
		model.addAttribute("tripulanteD", tripulante1);
		return agregarTripulante(model);
	}
}
