package ar.edu.unju.edm.tracking.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Tripulante;
import ar.edu.unju.edm.tracking.modelo.Vehiculo;

@Service
public interface ITripulanteService  {
	public void guardarTripulante(Tripulante unTripulante);
	public Iterable<Tripulante> listar();
	public void delete(Integer id);
	public Tripulante editar(Integer id) throws Exception;
	public Tripulante listarId(Integer id) throws Exception;
	public void guardarTripulanteTracking (Tripulante unTripulante);
	public void guardarTripulanteEncontrado (Tripulante unTripulante);
	public Tripulante buscarTripulante(String documento) throws Exception;
	public void borrarTripulantesLista();
	public List<Tripulante> buscarTodosLosTripulantes();
	
	public Integer devolverIdTripulante(Tripulante tripulante);
}
