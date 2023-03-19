package br.com.marcoscsouza.viaCepApp.controller;

import br.com.marcoscsouza.viaCepApp.entities.Usuario;
import br.com.marcoscsouza.viaCepApp.entities.ViaCepResponse;
import br.com.marcoscsouza.viaCepApp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public List<Usuario> findUsers(){
        return usuarioService.findUsers();
    }

    @PostMapping
    public String criarUsuario(@RequestBody Usuario usuario){



        usuarioService.criarUsuario(usuario);
        return "Usuario criado com sucesso!";
    }

    @GetMapping("/{id}")
    public Usuario findUserById(@PathVariable Long id){
        return usuarioService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id){
        usuarioService.deleteUserById(id);
        return "Usuario deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public String updateUserById(@PathVariable Long id, @RequestBody Usuario usuario){
        usuarioService.updateUserById(id, usuario);
        return "Usuario atualizado com sucesso!";
    }
}
