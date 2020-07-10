package ar.edu.unju.edm.tracking.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.tracking.modelo.Vehiculo;

@Repository
public interface IVehiculoRepository extends CrudRepository<Vehiculo, Integer>{
	public Optional<Vehiculo> findBypatente(String patente);
}
