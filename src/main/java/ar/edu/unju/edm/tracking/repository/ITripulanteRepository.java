package ar.edu.unju.edm.tracking.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.tracking.modelo.Tripulante;

@Repository
public interface ITripulanteRepository extends CrudRepository<Tripulante, Integer>{
	public Optional<Tripulante> findBydocumento(String documento);
}
