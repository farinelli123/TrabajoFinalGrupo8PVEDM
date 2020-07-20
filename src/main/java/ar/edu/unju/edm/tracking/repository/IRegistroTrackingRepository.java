package ar.edu.unju.edm.tracking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import ar.edu.unju.edm.tracking.modelo.Localidad;
//import ar.edu.unju.edm.repository.LocalDateTime;
//import ar.edu.unju.edm.repository.Long;
import ar.edu.unju.edm.tracking.modelo.RegistroTracking;
import ar.edu.unju.edm.tracking.modelo.Tripulante;
import ar.edu.unju.edm.tracking.modelo.Vehiculo;

@Repository
public interface IRegistroTrackingRepository extends CrudRepository<RegistroTracking, Integer> {

	List<RegistroTracking> findByvehiculoOrderByFechaHoraAsc(Vehiculo vehiculo);
	
	@Query("SELECT a FROM RegistroTracking a WHERE a.localidad.idLocalidad = :id and a.fechaHora between :date1 and :date2")

	List<RegistroTracking> findByFechaHoraBetween(@Param("date1") LocalDateTime date1, @Param("date2") LocalDateTime date2, @Param("id") Integer id);

	RegistroTracking findByRegistroId(Integer id);

}
