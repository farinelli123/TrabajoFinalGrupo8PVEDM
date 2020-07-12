package ar.edu.unju.edm.tracking.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Vehiculo;

@Service
public interface IVehiculoService {
	public void guardarVehiculo(Vehiculo unVehiculo);
	public Iterable<Vehiculo> listar();
	public void delete(Integer id);
	public Vehiculo editar(Integer id) throws Exception;
	public Vehiculo listarId(Integer id) throws Exception;
	public void guardarVehiculoEncontrado (Vehiculo unVehiculo);
	public Vehiculo buscarVehiculo(String patente) throws Exception;
	public void borrarVehiculosLista();
	public List<Vehiculo> buscarTodosLosVehiculos();
	public Vehiculo obtenerVehiculo(Vehiculo vehiculo);
	
	public Integer devolverIdPatente(Vehiculo vehiculo);
}
