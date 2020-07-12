package ar.edu.unju.edm.tracking.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.RegistroTracking;
import ar.edu.unju.edm.tracking.modelo.Tripulante;
import ar.edu.unju.edm.tracking.modelo.Vehiculo;
import ar.edu.unju.edm.tracking.repository.IRegistroTrackingRepository;

@Service
public class IRegistroTrackingServiceImp implements IRegistroTrackingService {
	@Autowired
	IRegistroTrackingRepository iRegistroTrackingRepository;
	List<Tripulante> tripulante1=new ArrayList<>();
	//List<Tripulante> tripulanteOrd=(List<Tripulante>) new Tripulante();
	
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
	//@Override
	//public List<RegistroTracking> obtenerRegistrosT(Tripulante tripulante) {
	//	List<RegistroTracking> registros = iRegistroTrackingRepository.findBytripulanteOrderByFechaHoraAsc(tripulante);
	//	return registros;
	//}
	@Override
	public void guardarTripulanteEncontrado(Tripulante unTripulante) {
		// TODO Auto-generated method stub
		tripulante1.add(unTripulante);
	}
	//@Override
	//public Tripulante guardarListaTripulante(Tripulante unTripulante) {
	//	Tripulante tripulanteOrd=iRegistroTrackingRepository.findAllByOrderByFechaHoraAsc(tripulante);
	//	return tripulanteOrd;
	//}

	@Override
	public List<RegistroTracking> obtenerRegistrosT(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

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

	//@Override
	//public List<Tripulante> obtenerTripulante() {
	//	// TODO Auto-generated method stub
	//	return tripulante;
	//}


	
}
