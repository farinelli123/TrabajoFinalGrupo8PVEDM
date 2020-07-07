package ar.edu.unju.edm.tracking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tracking.modelo.Usuario;
import ar.edu.unju.edm.tracking.repository.IUsuarioRepository;
@Service
public class IUsuarioServiceImp implements IUsuarioService {
	@Autowired
	IUsuarioRepository iUsuarioRepository;
	@Override
	public void guardarUsuario(Usuario unUsuario) {
		String pw= unUsuario.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		unUsuario.setPassword(bCryptPasswordEncoder.encode(pw));
		iUsuarioRepository.save(unUsuario);
	}
	@Override
	public Iterable<Usuario> listar() {
		// TODO Auto-generated method stub
		return iUsuarioRepository.findAll();
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		iUsuarioRepository.deleteById(id);
	}
}
