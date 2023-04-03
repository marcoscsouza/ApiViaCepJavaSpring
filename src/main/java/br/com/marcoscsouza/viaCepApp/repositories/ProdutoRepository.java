package br.com.marcoscsouza.viaCepApp.repositories;

import br.com.marcoscsouza.viaCepApp.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT p FROM Produto p WHERE p.usuario.id = :idUsuario")
    List<Produto> obterLista(Integer idUsuario);

    //obterListaPageable
    @Query("SELECT p FROM Produto p")
    List<Produto> obterLista(Integer pagina, Integer qtdRegistros);



}
