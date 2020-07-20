package ar.edu.unju.edm.tracking.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Fecha;
import ar.edu.unju.edm.tracking.modelo.Localidad;
import ar.edu.unju.edm.tracking.modelo.RegistroTracking;
import ar.edu.unju.edm.tracking.modelo.Tripulante;
import ar.edu.unju.edm.tracking.modelo.Vehiculo;
import ar.edu.unju.edm.tracking.repository.IRegistroTrackingRepository;

@Service
public class IRegistroTrackingServiceImp implements IRegistroTrackingService {
	@Autowired
	IRegistroTrackingRepository iRegistroTrackingRepository;
	List<Tripulante> tripulante1=new ArrayList<>();
	private List<RegistroTracking> registros = new ArrayList<>();
	private List<Tripulante> tripulanteS = new ArrayList<>();
	private Fecha consultaAuxiliar = new Fecha();
	
	@Override
	public void guardarRegistro(RegistroTracking unRegistro) {
		// TODO Auto-generated method stub
		unRegistro.setFechaHora(LocalDateTime.now());
		iRegistroTrackingRepository.save(unRegistro);
	}

	@Override
	public List<RegistroTracking> obtenerRegistrosV(Vehiculo vehiculo) {
		List<RegistroTracking> registros = iRegistroTrackingRepository.findByvehiculoOrderByFechaHoraAsc(vehiculo);
		return registros;
	}

	@Override
	public void guardarTripulanteEncontrado(Tripulante unTripulante) {
		// TODO Auto-generated method stub
		tripulante1.add(unTripulante);
	}
	
	//@Override
	//public List<RegistroTracking> obtenerRegistrosT(Integer id) {
		// TODO Auto-generated method stub
		//return null;
	//}

	@Override
	public List<RegistroTracking> obtenerRegistrosT(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tripulante> obtenerTripulante() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<RegistroTracking> obtenerRegistrosCD(Tripulante tripulante) {		
		registros = tripulante.getRegistrosT();
		return registros;
	}

	@Override
	public Fecha obtenerFechas() {
		return consultaAuxiliar;
	}

	@Override
	public List<RegistroTracking> obtenerRegistrosOL(LocalDateTime date1, LocalDateTime date2, Integer id) {
		List<RegistroTracking> registros = iRegistroTrackingRepository.findByFechaHoraBetween(date1, date2, id);
		return registros;
	}

	@Override
	public RegistroTracking buscarRegistro(Integer id) {
		return iRegistroTrackingRepository.findByRegistroId(id);
	}

	@Override
	public List<Tripulante> obtenerTripulantes(RegistroTracking registroTracking) {
		tripulanteS = registroTracking.getTripulante();
		return tripulanteS;
	}

	@Override
	public void guardarFechas(Fecha consulta) {
		consultaAuxiliar = consulta;
	}
	
	/**@Override
	public RegistroTracking buscarRegistro(Integer id) {
		return iRegistroTrackingRepository.findByIdRegistro(id);
	}
	
	@Override
	public List<Tripulante> obtenerTripulantes(RegistroTracking registroTracking) {
		
		tripulantes = registroTracking.getTripulantes();
		return tripulantes;
	}**/
}
