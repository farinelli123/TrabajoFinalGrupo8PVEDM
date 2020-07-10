package ar.edu.unju.edm.tracking.Service;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Localidad;

@Service
public interface ILocalidadService {
	public void guardarLocalidad(Localidad unaLocalidad);
	public Iterable<Localidad> listarLocalidad();
	public void borrarLocalidad(Integer id);
	public Localidad editar(Integer id) throws Exception;
	public Localidad listarId(Integer id) throws Exception;
	public Localidad obtenerLocalidad(Iterable<Localidad> localidad);
}
