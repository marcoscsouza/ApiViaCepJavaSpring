package br.com.marcoscsouza.viaCepApp.controller;

import br.com.marcoscsouza.viaCepApp.service.EnderecoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/cep")
public class CepController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/busca")
    public String buscaCep(@RequestParam @Parameter(description = "CEP a ser buscado",
                example = "26155070",
                required = true,
                in = ParameterIn.QUERY
                ) String cep ){
        return enderecoService.buscaCep(cep);
    }


}
