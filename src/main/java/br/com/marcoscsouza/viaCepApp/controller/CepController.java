package br.com.marcoscsouza.viaCepApp.controller;

import br.com.marcoscsouza.viaCepApp.entities.Endereco;
import br.com.marcoscsouza.viaCepApp.entities.ViaCepAddress;
import br.com.marcoscsouza.viaCepApp.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/cep")
public class CepController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/busca")
    public String buscaCep(@RequestParam String cep){
        return enderecoService.buscaCep(cep);
    }


}
