package ar.edu.unju.edm.tracking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.tracking.modelo.RegistroTracking;

@Repository
public interface IRegistroTrackingRepository extends CrudRepository<RegistroTracking, Integer> {

}
