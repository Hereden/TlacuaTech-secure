package tlacuariders.mx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tlacuariders.mx.models.UsuariosModel;


public interface UsuarioRepository extends JpaRepository<UsuariosModel, Long> {

	UsuariosModel findByUsername(String username);
}
