package br.com.procurarendereco.viacep;

import br.com.procurarendereco.Util;
import br.com.procurarendereco.dominio.Endereco;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Struct;

import static br.com.procurarendereco.viacep.AcharEOrganizar.organizarEndereco;

public class ServicoDeCep {
    public static String webService = "https://viacep.com.br/ws/";
    public static int codigoSucesso = 200;

    public static Endereco buscaEndereco(String cep) throws Exception {
        String urlParaChamada = webService + cep + "/json";

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso) {
                throw new RuntimeException("HTTP error code: " + conexao.getResponseCode());
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String jsonEmString = Util.converteJsonEmString(resposta);

            Endereco endereco = organizarEndereco(jsonEmString);

            return endereco;

        } catch (Exception e) {
            throw new Exception("Erro: " + e);
        }
    }
}
