package ar.edu.unju.edm.tracking.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import ar.edu.unju.edm.tracking.modelo.Usuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {
	public Optional<Usuario> findBynombreUsuario(String nombreUsuario);
}
