package ar.edu.unju.edm.tracking.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

//import ar.edu.unju.edm.tracking.controller.ConsultaFecha;
import ar.edu.unju.edm.tracking.modelo.Fecha;
import ar.edu.unju.edm.tracking.modelo.Localidad;
import ar.edu.unju.edm.tracking.modelo.RegistroTracking;
import ar.edu.unju.edm.tracking.modelo.Tripulante;
import ar.edu.unju.edm.tracking.modelo.Vehiculo;

@Service
public interface IRegistroTrackingService {
	public void guardarRegistro(RegistroTracking unRegistro);
	
	public List<RegistroTracking> obtenerRegistrosV(Vehiculo vehiculo);
	//public List<RegistroTracking> obtenerRegistrosT(Integer id);
	public void guardarTripulanteEncontrado(Tripulante unTripulante);
	public List<Tripulante> obtenerTripulante();
	public List<RegistroTracking> obtenerRegistrosT(Integer id);
	public List<RegistroTracking> obtenerRegistrosCD(Tripulante tripulante);
	//public RegistroTracking buscarRegistro(Integer id);
	//public List<Tripulante> obtenerTripulantes(RegistroTracking registroTracking);

	public Fecha obtenerFechas();

	public List<RegistroTracking> obtenerRegistrosOL(LocalDateTime date1, LocalDateTime date2, Integer id);

	public RegistroTracking buscarRegistro(Integer id);

	public List<Tripulante> obtenerTripulantes(RegistroTracking registroTracking);

	public void guardarFechas(Fecha consulta);
}
