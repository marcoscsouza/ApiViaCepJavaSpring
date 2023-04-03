package br.com.marcoscsouza.viaCepApp.service;

import br.com.marcoscsouza.viaCepApp.clients.IEnderecoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class EnderecoService {

    @Autowired
    private IEnderecoClient enderecoClient;

    public String feingCep(String cep) {
        return enderecoClient.buscaCep(cep);
    }

    public String buscaCep(String numeroCep) {
        String output = "";
        try {
            String url = "https://viacep.com.br/ws/"+numeroCep+"/json";

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String line;

            while ((line = br.readLine()) != null) {
                output += line;
            }

            conn.disconnect();

        }catch (IOException e){
            System.out.println("error! " + e.getMessage());
        }
        return output;
    }

}
