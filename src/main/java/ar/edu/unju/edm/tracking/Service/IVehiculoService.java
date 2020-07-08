package ar.edu.unju.edm.tracking.Service;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Vehiculo;

@Service
public interface IVehiculoService {
	public void guardarVehiculo(Vehiculo unVehiculo);
	public Iterable<Vehiculo> listar();
	public void delete(Integer id);
	public Vehiculo editar(Integer id) throws Exception;
	public Vehiculo listarId(Integer id) throws Exception;
}
