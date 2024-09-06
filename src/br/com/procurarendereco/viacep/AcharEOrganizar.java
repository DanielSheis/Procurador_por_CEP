package br.com.procurarendereco.viacep;

import br.com.procurarendereco.dominio.Endereco;

public class AcharEOrganizar {
    public static Endereco organizarEndereco(String jsonEmString) {
        Endereco endereco = new Endereco();

        endereco.setLogradouro(acharEndereco("logradouro", jsonEmString));
        endereco.setBairro(acharEndereco("bairro", jsonEmString));
        endereco.setLocalidade(acharEndereco("localidade", jsonEmString));

        return endereco;
    }

    public static String acharEndereco(String nomeEndereco, String nomeJsonEmString) {
        for (int i = 0; i < nomeJsonEmString.length(); i++) {

            if (nomeJsonEmString.charAt(i) == nomeEndereco.charAt(0)) {

                int j;
                for ( j = 0; j < nomeEndereco.length(); j++) {
                    if (nomeJsonEmString.charAt(i) != nomeEndereco.charAt(j)) break;

                    i++;
                }

                if (j  == nomeEndereco.length()) {
                    return passarResposta(i, nomeJsonEmString);
                }
            }

        }

        return null;
    }

    public static String passarResposta(int posicaoLetra, String nomeJsonEmString) {
        String resposta = "";
        posicaoLetra++;

        while (true) {
            if (nomeJsonEmString.charAt(posicaoLetra) == '"') {
                posicaoLetra++;

                while (nomeJsonEmString.charAt(posicaoLetra) != '"') {
                    resposta += nomeJsonEmString.charAt(posicaoLetra);
                    posicaoLetra++;
                }
                    return resposta;
            }

            posicaoLetra++;
        }
    }
}