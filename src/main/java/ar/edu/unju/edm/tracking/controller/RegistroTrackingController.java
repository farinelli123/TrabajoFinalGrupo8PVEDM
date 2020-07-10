package ar.edu.unju.edm.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.tracking.Service.ILocalidadService;
import ar.edu.unju.edm.tracking.Service.IRegistroTrackingService;
import ar.edu.unju.edm.tracking.Service.ITripulanteService;
import ar.edu.unju.edm.tracking.Service.IVehiculoService;
import ar.edu.unju.edm.tracking.modelo.RegistroTracking;
import ar.edu.unju.edm.tracking.modelo.Tripulante;
import ar.edu.unju.edm.tracking.modelo.Vehiculo;

@Controller
@RequestMapping
public class RegistroTrackingController {
	
	@Autowired
	IRegistroTrackingService registroTrackingService;
	@Autowired
	ITripulanteService tripulanteService;
	@Autowired
	Tripulante unTripulante;
	@Autowired 
	IVehiculoService vehiculoService;
	@Autowired
	Vehiculo unVehiculo;
	@Autowired
	ILocalidadService localidadService;
	
	@GetMapping("/agregarRegistro")
	public String crearRegistro(Model model) throws Exception {
		model.addAttribute("RegistroTrackingD", new RegistroTracking());
		model.addAttribute("tripulantes", tripulanteService.buscarTodosLosTripulantes());
		model.addAttribute("tripulanteD", unTripulante);
		model.addAttribute("vehiculos", vehiculoService.buscarTodosLosVehiculos());
		model.addAttribute("vehiculoD", unVehiculo);
		model.addAttribute("localidades", localidadService.listarLocalidad());
		return "RegistroTracking";
	}
	@PostMapping("/agregarRegistro")
	public String crearRegistroFinal(@ModelAttribute("RegistroTrackingD") RegistroTracking registro, Model model) {
		registro.setTripulante(tripulanteService.buscarTodosLosTripulantes());
		registro.setVehiculo(vehiculoService.obtenerVehiculo(unVehiculo));
		try {
			registroTrackingService.guardarRegistro(registro);
		} catch (Exception e) {
			model.addAttribute("formTripulanteErrorMessage", e.getMessage());
		}
		tripulanteService.borrarTripulantesLista();
		vehiculoService.borrarVehiculosLista();
		return "redirect:/agregarRegistro";
	}
	@PostMapping("/buscarTripulante")
	public String buscarTripulante(@ModelAttribute Tripulante tripulante, Model model) throws Exception{
		try {
			Tripulante tripulanteEncontrado = tripulanteService.buscarTripulante(tripulante.getDocumento());
			try {
				tripulanteService.guardarTripulanteEncontrado(tripulanteEncontrado);
			} catch (Exception e) {
				model.addAttribute("FormTripulanteErrorMessage", e.getMessage());
			}
		} catch (Exception e) {
			model.addAttribute("FormTripulanteErrorMessage", e.getMessage());
		}
		return 	crearRegistro(model); 
	}
	@PostMapping("/buscarVehiculo")
	public String buscarVehiculo(@ModelAttribute Vehiculo vehiculo, Model model) throws Exception{
		try {
			Vehiculo vehiculoEncontrado = vehiculoService.buscarVehiculo(vehiculo.getPatente());
			try {
				vehiculoService.guardarVehiculoEncontrado(vehiculoEncontrado);
			} catch(Exception e) {
				model.addAttribute("FormVehiculoErrorMessage", e.getMessage());
			}
		} catch(Exception e) {
			model.addAttribute("FormVehiculoErrorMessage", e.getMessage());
		}
		return crearRegistro(model);
	}
}
