package ar.edu.unju.edm.tracking.Service;

import java.util.Optional;

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

	@Override
	public Iterable<Tripulante> listar() {
		// TODO Auto-generated method stub
		return iTripulanteRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		iTripulanteRepository.deleteById(id);
	}

	@Override
	public Optional<Tripulante> listarId(int id) {
		// TODO Auto-generated method stub
		return iTripulanteRepository.findById(id);
	}
}