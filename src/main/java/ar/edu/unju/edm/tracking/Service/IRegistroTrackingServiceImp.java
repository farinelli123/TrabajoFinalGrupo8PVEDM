package ar.edu.unju.edm.tracking.Service;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.RegistroTracking;
import ar.edu.unju.edm.tracking.repository.IRegistroTrackingRepository;

@Service
public class IRegistroTrackingServiceImp implements IRegistroTrackingService {
	@Autowired
	IRegistroTrackingRepository iRegistroTrackingRepository;
	
	@Override
	public void guardarRegistro(RegistroTracking unRegistro) {
		// TODO Auto-generated method stub
		unRegistro.setFechaHora(LocalDateTime.now());
		iRegistroTrackingRepository.save(unRegistro);
	}
	
}
