package ar.edu.unju.edm.tracking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Vehiculo;
import ar.edu.unju.edm.tracking.repository.IVehiculoRepository;

@Service
public class IVehiculoServiceImp implements IVehiculoService {
	@Autowired
	IVehiculoRepository iVehiculoRepository;
	@Override
	public void guardarVehiculo(Vehiculo unVehiculo) {
		// TODO Auto-generated method stub
		iVehiculoRepository.save(unVehiculo);
	}
	@Override
	public Iterable<Vehiculo> listar() {
		// TODO Auto-generated method stub
		return iVehiculoRepository.findAll();
	}

}
