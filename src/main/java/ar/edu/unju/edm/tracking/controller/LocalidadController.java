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

import ar.edu.unju.edm.tracking.Service.ILocalidadService;
import ar.edu.unju.edm.tracking.modelo.Localidad;

@Controller
@RequestMapping
public class LocalidadController {
	@Autowired
	ILocalidadService localidadService;
	
	@GetMapping("/nuevaLocalidad")
	public String agregarLocalidad(Model model) {
		if (!model.containsAttribute("localidadD")) {
			model.addAttribute("localidadD", new Localidad());
		}
		return "FormLocalidad";
	}
	@PostMapping("/saveLocalidad")
	public String guardarLocalidad(@Valid @ModelAttribute("localidaD") Localidad localidad, Model Model) {
		localidadService.guardarLocalidad(localidad);
		return "redirect:/listarLocalidad";
	}
	@GetMapping("/listarLocalidad")
	public String listarLocalidad(Model model) {
		model.addAttribute("localidades", localidadService.listarLocalidad());
		return "vistaLocalidad";
	}
	@GetMapping("/deleteLocalidad/{id}")
	public String eliminarLocalidad(@PathVariable int id,Model model) {
		localidadService.borrarLocalidad(id);
		return "redirect:/ListarLocalidad";
	}
	@GetMapping("/editarLocalidad/{id}")
	public String editarLocalidad(Model model, @PathVariable(name="id") Integer id) throws Exception{
		Localidad localidad1=localidadService.editar(id);
		model.addAttribute("localidadD", localidad1);
		return agregarLocalidad(model);
	}
}
