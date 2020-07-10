package ar.edu.unju.edm.tracking.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Tripulante;
import ar.edu.unju.edm.tracking.repository.ITripulanteRepository;

@Service
public class ITripulanteServiceImp implements ITripulanteService {
	@Autowired
	ITripulanteRepository iTripulanteRepository;
	private List<Tripulante> listadoAux = new ArrayList<>();
	
	public void guardarTripulante(Tripulante unTripulante) {
		// TODO Auto-generated method stub
		iTripulanteRepository.save(unTripulante);
		listadoAux.add(unTripulante);
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
	public Tripulante editar(Integer id) throws Exception {
		Tripulante tripulanteG=listarId(id);
		return tripulanteG;
	}
	
	@Override
	public Tripulante listarId(Integer id) throws Exception{
		// TODO Auto-generated method stub
		return iTripulanteRepository.findById(id).orElseThrow(()-> new Exception("Error"));
	}
	@Override
	public void guardarTripulanteTracking(Tripulante unTripulante) {
		// TODO Auto-generated method stub
		iTripulanteRepository.save(unTripulante);
		listadoAux.add(unTripulante);
	}

	@Override
	public void guardarTripulanteEncontrado(Tripulante unTripulante) {
		// TODO Auto-generated method stub
		listadoAux.add(unTripulante);
	}

	@Override
	public Tripulante buscarTripulante(String documento) throws Exception {
		// TODO Auto-generated method stub
		return iTripulanteRepository.findBydocumento(documento).orElseThrow(()-> new Exception("El tripulante no existe"));
	}

	@Override
	public List<Tripulante> buscarTodosLosTripulantes() {
		// TODO Auto-generated method stub
		return listadoAux;
	}

	@Override
	public void borrarTripulantesLista() {
		// TODO Auto-generated method stub
		listadoAux = new ArrayList<>();
		
	}
}