package br.com.procurarendereco.cliente;

import br.com.procurarendereco.dominio.Endereco;
import br.com.procurarendereco.viacep.ServicoDeCep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Informe o CEP");
        String cep = new Scanner(System.in).nextLine();
        Endereco endereco = ServicoDeCep.buscaEndereco(cep);

        System.out.println("------------------------------------------");

        System.out.println("Logradouro: " + endereco.getLogradouro());
        System.out.println("Bairro: " + endereco.getBairro());
        System.out.println("localidade: " + endereco.getLocalidade());

        System.out.println("------------------------------------------");
    }
}
