package ar.edu.unju.edm.tracking.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.RegistroTracking;
import ar.edu.unju.edm.tracking.modelo.Tripulante;
import ar.edu.unju.edm.tracking.modelo.Vehiculo;

@Service
public interface IRegistroTrackingService {
	public void guardarRegistro(RegistroTracking unRegistro);
	
	public List<RegistroTracking> obtenerRegistrosV(Vehiculo vehiculo);
	public List<RegistroTracking> obtenerRegistrosT(Integer id);
	public void guardarTripulanteEncontrado(Tripulante unTripulante);
	public List<Tripulante> obtenerTripulante();

	List<RegistroTracking> obtenerRegistrosT(Long id);
	
	//public Tripulante guardarListaTripulante(Tripulante unTripulante);
}
