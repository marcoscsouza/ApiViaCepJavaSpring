package br.com.marcoscsouza.viaCepApp.service;

import br.com.marcoscsouza.viaCepApp.entities.Usuario;
import br.com.marcoscsouza.viaCepApp.entities.ViaCepAddress;
import br.com.marcoscsouza.viaCepApp.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void validarCep(Usuario usuario){

    }

    public Usuario createUser(Usuario usuario, String cep) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://viacep.com.br/ws/"+cep+"/json";

        ViaCepAddress response = restTemplate.getForObject(url, ViaCepAddress.class);

        if (response.getCep() == null){
            throw new IllegalArgumentException("Invalid Cep!");
        }
        usuario.setEndereco(
                response.getLogradouro() +
                        ", " + response.getBairro() +
                        ", " + response.getLocalidade() +
                        ", " + response.getUf());

        return usuarioRepository.save(usuario);
    }
    public List<Usuario> findUsers(){
        return usuarioRepository.findAll();
    }

    public Usuario findUserById(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    public void deleteUserById(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public void updateUserById(Integer id, Usuario usuario) {
        Usuario usuarioAtual = usuarioRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid user Id:" + id));

        usuarioAtual.setNome(usuario.getNome());
        usuarioAtual.setEmail(usuario.getEmail());
        usuarioAtual.setTelefone(usuario.getTelefone());
        usuarioAtual.setFoto(usuario.getFoto());

        usuarioRepository.save(usuarioAtual);
    }
}
