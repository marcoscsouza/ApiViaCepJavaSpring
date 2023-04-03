package br.com.marcoscsouza.viaCepApp.service;

import br.com.marcoscsouza.viaCepApp.entities.Produto;
import br.com.marcoscsouza.viaCepApp.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto createProduct(Produto produto) {
        return produtoRepository.save(produto);
    }
    public void deleteProduct(Integer key) {
        produtoRepository.deleteById(key);
    }
    public List<Produto> findProducts() {
        return (List<Produto>) produtoRepository.findAll();
    }
    public List<Produto> findProductsByUser(Integer idUsuario) {
        return produtoRepository.obterLista(idUsuario);
    }
    //obterlistapageable
    public List<Produto> findProductsPageable( Integer pagina, Integer qtdRegistros) {
        return produtoRepository.obterLista(pagina, qtdRegistros);
    }

    public void updateProduct(Integer id, Produto produto) {
        Produto produtoAtual = produtoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid product Id:" + id));
        produtoAtual.setNome(produto.getNome());
        produtoAtual.setQuantidade(produto.getQuantidade());
        produtoAtual.setPreco(produto.getPreco());

        produtoRepository.save(produtoAtual);
    }


}
