package ar.edu.unju.edm.tracking.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.edm.tracking.modelo.Localidad;

@Repository
public interface ILocalidadRepository extends CrudRepository<Localidad, Integer> {

	Optional<Localidad> findByNombre(String nombre);
	
}
