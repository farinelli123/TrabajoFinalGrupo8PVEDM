package ar.edu.unju.edm.tracking.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.tracking.Service.ILocalidadService;
import ar.edu.unju.edm.tracking.Service.IRegistroTrackingService;
import ar.edu.unju.edm.tracking.Service.ITripulanteService;
import ar.edu.unju.edm.tracking.Service.IVehiculoService;
import ar.edu.unju.edm.tracking.modelo.Fecha;
import ar.edu.unju.edm.tracking.modelo.Localidad;
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
	public String buscarTripulante(@ModelAttribute Tripulante tripulante, Model model) throws Exception {
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
		return crearRegistro(model);
	}

	@PostMapping("/buscarVehiculo")
	public String buscarVehiculo(@ModelAttribute Vehiculo vehiculo, Model model) throws Exception {
		try {
			vehiculoService.borrarVehiculosLista();
			Vehiculo vehiculoEncontrado = vehiculoService.buscarVehiculo(vehiculo.getPatente());
			try {
				vehiculoService.guardarVehiculoEncontrado(vehiculoEncontrado);
			} catch (Exception e) {
				model.addAttribute("FormVehiculoErrorMessage", e.getMessage());
				vehiculoService.borrarVehiculosLista();
			}
		} catch (Exception e) {
			model.addAttribute("FormVehiculoErrorMessage", e.getMessage());
		}
		return crearRegistro(model);
	}

	@GetMapping("/consultas1")
	public String consultar1(Model model) {
		model.addAttribute("vehiculoO", unVehiculo);
		return "ConsultaPatente";
	}
	
	@PostMapping("/buscarListadoPatente")
	public String buscarListadoPatente(@ModelAttribute("vehiculoO") Vehiculo vehiculo, Model model) throws Exception {
		try {
			Vehiculo vehiculoEncontrado = vehiculoService.buscarVehiculo(vehiculo.getPatente());
			try {
				model.addAttribute("registrosTrackingO", registroTrackingService.obtenerRegistrosV(vehiculoEncontrado));
			} catch (Exception e) {
				model.addAttribute("formVehiculoErrorMessage", e.getMessage());
			}
		} catch (Exception e) {
			model.addAttribute("formVehiculoErrorMessage", e.getMessage());
		}

		return "ConsultaPatente";
	}

	@GetMapping("/consultas2")
	public String consultar2(Model model) {
		model.addAttribute("tripulanteD", unTripulante);
		return "ConsultaTripulante";
	}

	@PostMapping("/buscarListadoTripulante") public String
	 buscarListadoTripulante(@ModelAttribute("tripulanteD") Tripulante unTripulante, Model model) throws Exception{ 
		try {
			Tripulante tripulanteEncontrado=tripulanteService.buscarTripulante(unTripulante.getDocumento());
	        try {
	        	model.addAttribute("registrosTrackingCD",registroTrackingService.obtenerRegistrosCD(tripulanteEncontrado));
	        }catch(Exception e){
	            model.addAttribute("formTripulanteErrorMessage", e.getMessage());
	        }
		}catch(Exception e) {
			model.addAttribute("formTripulanteErrorMessage", e.getMessage());	
			return consultar2(model);
		}
		return "ConsultaTripulante";
		}
	
	@GetMapping("/consultas3")
	public String consultar3( Model model) {
		Fecha unaConsulta = new Fecha();
		model.addAttribute("consulta",unaConsulta);	
		return "ConsultaVehiculo";
	}
	 
	@PostMapping("/buscarListadoLocalidad")
	public String buscarListadoLocalidad(@ModelAttribute ("localidadD") Localidad localidad, @ModelAttribute ("consulta") Fecha consulta, Model model) throws Exception{
		
		try{
			Localidad localidadEncontrada = localidadService.buscarLocalidad(localidad.getNombre());
			try{
				
				consulta = registroTrackingService.obtenerFechas();
				Integer id = localidadService.devolverIdLocalidad(localidadEncontrada);
				LocalDateTime date1 = consulta.getFechaH1().atStartOfDay();
				LocalDateTime date2 = consulta.getFechaH2().atStartOfDay();
				model.addAttribute("registrosTrackingOL",registroTrackingService.obtenerRegistrosOL( date1, date2, id));				
			}catch(Exception e){
				model.addAttribute("formLocalidadErrorMessage", e.getMessage());							
			}
		}catch(Exception e){
			model.addAttribute("formLocalidadErrorMessage", e.getMessage());
			return consultar2(model);
		}
		
		return "ConsultaVehiculo";
	}
	
	@PostMapping("/buscarFechas")
	public String buscarFechas(@ModelAttribute ("consulta") Fecha consulta, Model model){
		 registroTrackingService.guardarFechas(consulta);
		return consultar2( model);
	}
}
