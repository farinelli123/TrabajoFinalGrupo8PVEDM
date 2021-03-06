package ar.edu.unju.edm.tracking.Service;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Usuario;

@Service
public interface IUsuarioService {
	public void guardarUsuario(Usuario unUsuario);
	public Iterable<Usuario> listar();
	public void delete(Integer id);
	public Usuario editar(Integer id) throws Exception;
	public Usuario listarId(Integer id) throws Exception;
}
