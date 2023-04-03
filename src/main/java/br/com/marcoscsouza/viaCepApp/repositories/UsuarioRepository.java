package br.com.marcoscsouza.viaCepApp.repositories;

import br.com.marcoscsouza.viaCepApp.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{





}
