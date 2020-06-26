package ar.edu.unju.edm.tracking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Tripulante;
import ar.edu.unju.edm.tracking.repository.ITripulanteRepository;
@Service
public class ITripulanteServiceImp implements ITripulanteService {
	@Autowired
	ITripulanteRepository iTripulanteRepository;

	@Override
	public void guardarTripulante(Tripulante unTripulante) {
		// TODO Auto-generated method stub
		iTripulanteRepository.save(unTripulante);
	}
}