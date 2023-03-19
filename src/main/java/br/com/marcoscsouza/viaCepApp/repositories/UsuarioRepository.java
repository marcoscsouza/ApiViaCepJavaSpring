package br.com.marcoscsouza.viaCepApp.repositories;

import br.com.marcoscsouza.viaCepApp.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

//    Usuario findByCep(String cep);



}
