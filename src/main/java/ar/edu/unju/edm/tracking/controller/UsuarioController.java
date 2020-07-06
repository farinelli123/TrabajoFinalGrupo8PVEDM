package ar.edu.unju.edm.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.tracking.Service.IUsuarioService;
import ar.edu.unju.edm.tracking.modelo.Usuario;

@Controller
@RequestMapping
public class UsuarioController {
	
	@Autowired
	IUsuarioService usuarioService;

	@GetMapping("/nuevoUsuario")
	public String agregarUsuario(Model model) {
		model.addAttribute("usuarioD",new Usuario());
		return "FormUsuario";
	}
	
	@PostMapping("/saveUsuario")
	public String guardarUsuario(@ModelAttribute Usuario usuario, Model model) {
		usuarioService.guardarUsuario(usuario);
		return "redirect:/listarUsuario";
	}
	@GetMapping("/listarUsuario")
	public String listarUsuario(Model model) {
		model.addAttribute("usuarios", usuarioService.listar());
		return "VistaUsuario";
	}
	@GetMapping("/deleteUsuario/{id}")
	public String eliminar(@PathVariable int id,Model model) {
		usuarioService.delete(id);
		return "redirect:/listarUsuario";
	}
}
