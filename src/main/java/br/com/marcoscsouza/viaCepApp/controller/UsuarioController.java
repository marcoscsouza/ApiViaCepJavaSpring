package br.com.marcoscsouza.viaCepApp.controller;

import br.com.marcoscsouza.viaCepApp.entities.Endereco;
import br.com.marcoscsouza.viaCepApp.entities.Usuario;
import br.com.marcoscsouza.viaCepApp.entities.ViaCepAddress;
import br.com.marcoscsouza.viaCepApp.service.EnderecoService;
import br.com.marcoscsouza.viaCepApp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    EnderecoService enderecoService;

    //CREATE
    @PostMapping("/criar")
    public String criarUsuario(@RequestBody Usuario usuario, @RequestParam String cep){

        usuarioService.createUser(usuario,cep);

        return "Usuario criado com sucesso!";
    }

    //READ
    @GetMapping("/listar")
    public List<Usuario> findUsers(){
        return usuarioService.findUsers();
    }

    @GetMapping("/listar/{id}")
    public Usuario findUserById(@PathVariable Integer id){
        return usuarioService.findUserById(id);
    }

    //UPDATE
    @PutMapping("/atualizar/{id}")
    public String updateUserById(@PathVariable Integer id, @RequestBody Usuario usuario){
        usuarioService.updateUserById(id, usuario);
        return "Usuario atualizado com sucesso!";
    }

    //DELETE
    @DeleteMapping("/deletar/{id}")
    public String deleteUserById(@PathVariable Integer id){
        usuarioService.deleteUserById(id);
        return "Usuario deletado com sucesso!";
    }

}
