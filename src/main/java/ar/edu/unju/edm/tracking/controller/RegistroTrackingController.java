package ar.edu.unju.edm.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.tracking.Service.IRegistroTrackingService;
import ar.edu.unju.edm.tracking.Service.ITripulanteService;
import ar.edu.unju.edm.tracking.modelo.RegistroTracking;
import ar.edu.unju.edm.tracking.modelo.Tripulante;

@Controller
@RequestMapping
public class RegistroTrackingController {
	
	@Autowired
	IRegistroTrackingService registroTrackingService;
	@Autowired
	ITripulanteService tripulanteService;
	@Autowired
	Tripulante unTripulante;
	
	@GetMapping("/agregarRegistro")
	public String crearRegistro(Model model) {
		model.addAttribute("RegistroTrackingD", new RegistroTracking());
		model.addAttribute("tripulantes", tripulanteService.buscarTodosLosTripulantes());
		model.addAttribute("tripulanteD", unTripulante);
		return "RegistroTracking";
	}
	@PostMapping("/agregarRegistro")
	public String crearRegistroFinal(@ModelAttribute("RegistroTrackingD") RegistroTracking registro, Model model) {
		registro.setTripulante(tripulanteService.buscarTodosLosTripulantes());
		try {
			registroTrackingService.guardarRegistro(registro);
		} catch (Exception e) {
			model.addAttribute("formAutorErrorMessage", e.getMessage());
		}
		tripulanteService.borrarTripulantesLista();
		return "redirect:/agregarRegistro";
	}
	@PostMapping("/buscarTripulante")
	public String buscarT(@ModelAttribute Tripulante tripulante, Model model) throws Exception{
		try {
			Tripulante tripulanteEncontrado = tripulanteService.buscarTripulante(tripulante.getDocumento());
			try {
				tripulanteService.guardarTripulanteEncontrado(tripulanteEncontrado);
			} catch (Exception e) {
				model.addAttribute("FormAutorErrorMessage", e.getMessage());
			}
		} catch (Exception e) {
			model.addAttribute("FormAutorErrorMessage", e.getMessage());
		}
		return 	crearRegistro(model); 
	}
}
