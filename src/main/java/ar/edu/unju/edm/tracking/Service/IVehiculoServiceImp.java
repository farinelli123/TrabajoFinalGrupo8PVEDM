package ar.edu.unju.edm.tracking.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Vehiculo;
import ar.edu.unju.edm.tracking.repository.IVehiculoRepository;

@Service
public class IVehiculoServiceImp implements IVehiculoService {
	@Autowired
	IVehiculoRepository iVehiculoRepository;
	private Vehiculo vehiculoAux = new Vehiculo();
	private List<Vehiculo> listadoAux = new ArrayList<>();
	@Override
	public void guardarVehiculo(Vehiculo unVehiculo) {
		// TODO Auto-generated method stub
		borrarVehiculosLista();
		iVehiculoRepository.save(unVehiculo);
		vehiculoAux = unVehiculo;
	}
	@Override
	public Iterable<Vehiculo> listar() {
		// TODO Auto-generated method stub
		return iVehiculoRepository.findAll()	;
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		iVehiculoRepository.deleteById(id);
		
	}
	@Override
	public Vehiculo editar(Integer id) throws Exception {
		Vehiculo vehiculoG=listarId(id);
		return vehiculoG;
	}
	
	@Override
	public Vehiculo listarId(Integer id) throws Exception{
		// TODO Auto-generated method stub
		return iVehiculoRepository.findById(id).orElseThrow(()-> new Exception("Error"));
	}
	@Override
	public void guardarVehiculoEncontrado(Vehiculo unVehiculo) {
		// TODO Auto-generated method stub
		vehiculoAux= unVehiculo;
	}
	@Override
	public Vehiculo buscarVehiculo(String patente) throws Exception {
		// TODO Auto-generated method stub
		return iVehiculoRepository.findBypatente(patente).orElseThrow(()-> new Exception("El vehiculo no existe"));
	}
	@Override
	public void borrarVehiculosLista() {
		// TODO Auto-generated method stub
		vehiculoAux = new Vehiculo();
		listadoAux = new ArrayList<>();
		
	}
	@Override
	public List<Vehiculo> buscarTodosLosVehiculos() {
		// TODO Auto-generated method stub
		listadoAux.add(vehiculoAux);
		return listadoAux;
	} 
	@Override
	public Vehiculo obtenerVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return vehiculoAux;
	}
	public Integer devolverIdPatente(Vehiculo vehiculo) {
		return vehiculo.getIdVehiculo();
	}
}
