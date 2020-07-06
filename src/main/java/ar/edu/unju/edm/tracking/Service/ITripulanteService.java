package ar.edu.unju.edm.tracking.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Tripulante;

@Service
public interface ITripulanteService  {
	public void guardarTripulante(Tripulante unTripulante);
	public Iterable<Tripulante> listar();
}
