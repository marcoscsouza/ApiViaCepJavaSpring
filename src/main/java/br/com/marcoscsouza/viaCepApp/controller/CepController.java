package br.com.marcoscsouza.viaCepApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class CepController {


    @GetMapping(value = "/cep")
    public String cep() {
        String output = "";
        try {
            String url = "https://viacep.com.br/ws/26155070/json";

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
