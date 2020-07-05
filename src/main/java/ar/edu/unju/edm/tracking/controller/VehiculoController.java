package ar.edu.unju.edm.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.tracking.Service.IVehiculoService;
import ar.edu.unju.edm.tracking.modelo.Vehiculo;

@Controller
@RequestMapping
public class VehiculoController {
	
	@Autowired
	IVehiculoService vehiculoService;

	@GetMapping("/nuevoVehiculo")
	public String agregarVehiculo(Model model) {
		model.addAttribute("vehiculoD" ,new Vehiculo());
		return "FormVehiculo";
	}

	@PostMapping("/saveVehiculo")
	public String guardarVehiculo(@ModelAttribute Vehiculo vehiculo, Model model) {
		vehiculoService.guardarVehiculo(vehiculo);
		return "redirect:/nuevoVehiculo"; 
	}
}
