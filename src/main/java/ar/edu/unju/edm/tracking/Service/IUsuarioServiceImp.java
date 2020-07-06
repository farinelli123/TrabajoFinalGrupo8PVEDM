package ar.edu.unju.edm.tracking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Usuario;
import ar.edu.unju.edm.tracking.repository.IUsuarioRepository;
@Service
public class IUsuarioServiceImp implements IUsuarioService {
	@Autowired
	IUsuarioRepository iUsuarioRepository;
	@Override
	public void guardarUsuario(Usuario unUsuario) {
		iUsuarioRepository.save(unUsuario);
	}
	@Override
	public Iterable<Usuario> listar() {
		// TODO Auto-generated method stub
		return iUsuarioRepository.findAll();
	}
}
