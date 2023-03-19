package br.com.marcoscsouza.viaCepApp.service;

import br.com.marcoscsouza.viaCepApp.entities.Usuario;
import br.com.marcoscsouza.viaCepApp.entities.ViaCepResponse;
import br.com.marcoscsouza.viaCepApp.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findUsers(){
        return usuarioRepository.findAll();
    }

    public void validarCep(Usuario usuario){
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://viacep.com.br/ws/"+usuario.getCep()+"/json";

        ViaCepResponse response = restTemplate.getForObject(url, ViaCepResponse.class);

        if (response.getCep() == null){
            throw new IllegalArgumentException("Invalid Cep!");
        }
        usuario.setEndereco(
                response.getLogradouro() +
                        ", " + response.getBairro() +
                        ", " + response.getLocalidade() +
                        ", " + response.getUf());
    }

    public Usuario criarUsuario(Usuario usuario) {

        validarCep(usuario);

        return usuarioRepository.save(usuario);
    }

    public Usuario findUserById(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public void deleteUserById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public void updateUserById(Long id, Usuario usuario) {
        Usuario usuario1 = usuarioRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid user Id:" + id));

        usuario1.setNome(usuario.getNome());
        usuario1.setCep(usuario.getCep());
        usuario1.setEmail(usuario.getEmail());
        usuario1.setTelefone(usuario.getTelefone());

        validarCep(usuario1);
        usuarioRepository.save(usuario1);
    }
}
