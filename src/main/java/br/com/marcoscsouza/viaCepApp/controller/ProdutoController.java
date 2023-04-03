package br.com.marcoscsouza.viaCepApp.controller;

import br.com.marcoscsouza.viaCepApp.entities.Produto;
import br.com.marcoscsouza.viaCepApp.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    //CREATE
    @PostMapping("/criar")
    public String createProduct(@RequestBody Produto produto){
        produtoService.createProduct(produto);
        return "Produto criado com sucesso!";
    }

    //READ
    @GetMapping("/listar")
    public List<Produto> findProdutos(){
        return produtoService.findProducts();
    }

    @GetMapping("/listar/{id}")
    public List<Produto> findProdutosByUser(@PathVariable Integer id){
        return produtoService.findProductsByUser(id);
    }

    @GetMapping("/listar/{pagina}/{qtdRegistros}")
    public List<Produto> findProdutosPageable(@PathVariable Integer pagina, @PathVariable Integer qtdRegistros){
        return produtoService.findProductsPageable(pagina, qtdRegistros);
    }

    //UPDATE

    @PutMapping("/atualizar/{id}")
    public String updateProduct(@PathVariable Integer id, @RequestBody Produto produto){
        produtoService.updateProduct(id, produto);
        return "Produto atualizado com sucesso!";
    }

    //DELETE
    @DeleteMapping("/deletar/{id}")
    public String deleteProduct(@PathVariable Integer id){
        produtoService.deleteProduct(id);
        return "Produto deletado com sucesso!";
    }

}
