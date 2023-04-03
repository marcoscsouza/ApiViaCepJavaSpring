package br.com.marcoscsouza.viaCepApp.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://viacep.com.br/ws/", name = "enderecoClient")
public interface IEnderecoClient {

    @GetMapping(value = "/{cep}/json")
    public String buscaCep(String cep);
}
