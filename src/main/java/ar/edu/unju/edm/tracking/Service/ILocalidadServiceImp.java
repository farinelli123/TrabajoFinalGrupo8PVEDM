package ar.edu.unju.edm.tracking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Localidad;
import ar.edu.unju.edm.tracking.repository.ILocalidadRepository;

@Service
public class ILocalidadServiceImp implements ILocalidadService {
	@Autowired
	ILocalidadRepository iLocalidadRepository;
	
	@Override
	public void guardarLocalidad(Localidad unaLocalidad) {
		// TODO Auto-generated method stub
		iLocalidadRepository.save(unaLocalidad);
	}

	@Override
	public Iterable<Localidad> listarLocalidad() {
		// TODO Auto-generated method stub
		return iLocalidadRepository.findAll();
	}

	@Override
	public void borrarLocalidad(Integer id) {
		// TODO Auto-generated method stub
		iLocalidadRepository.deleteById(id);
	}

	@Override
	public Localidad editar(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Localidad localidadG=listarId(id);
		return localidadG;
	}

	@Override
	public Localidad listarId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return iLocalidadRepository.findById(id).orElseThrow(()-> new Exception("Error"));
	}
	
}
