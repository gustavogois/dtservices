package pt.gois.dtservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.gois.dtservices.model.Utilizador;

public interface UsuarioRepository extends JpaRepository <Utilizador, Long>{
	
	public Optional<Utilizador> findByEmail(String email);

}
