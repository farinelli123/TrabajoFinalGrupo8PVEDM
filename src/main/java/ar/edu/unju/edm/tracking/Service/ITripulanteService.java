package ar.edu.unju.edm.tracking.Service;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Tripulante;

@Service
public interface ITripulanteService  {
	public void guardarTripulante(Tripulante unTripulante);
	public Iterable<Tripulante> listar();
	public void delete(Integer id);
	public Tripulante editar(Integer id) throws Exception;
	public Tripulante listarId(Integer id) throws Exception;
}
