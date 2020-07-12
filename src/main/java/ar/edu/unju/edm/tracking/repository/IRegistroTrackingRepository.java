package ar.edu.unju.edm.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.tracking.modelo.RegistroTracking;
import ar.edu.unju.edm.tracking.modelo.Tripulante;
import ar.edu.unju.edm.tracking.modelo.Vehiculo;

@Repository
public interface IRegistroTrackingRepository extends CrudRepository<RegistroTracking, Integer> {

	List<RegistroTracking> findByvehiculoOrderByFechaHoraAsc(Vehiculo vehiculo);

	//List<RegistroTracking> findBytripulanteOrderByFechaHoraAsc(List<Tripulante> tripulante);
	
	//Tripulante findAllByOrderByFechaHoraAsc(Tripulante tripulante);
	

}
