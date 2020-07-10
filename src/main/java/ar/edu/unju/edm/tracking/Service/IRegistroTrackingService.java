package ar.edu.unju.edm.tracking.Service;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.RegistroTracking;

@Service
public interface IRegistroTrackingService {
	public void guardarRegistro(RegistroTracking unRegistro);
}
