package br.com.fiap.main;

import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EnderecoDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteInserirEndereco {

    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j ){
        return Integer.parseInt(JOptionPane.showInputDialog(j));}

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Endereco objEndereco = new Endereco();
        EnderecoDAO objEnderecoDAO = new EnderecoDAO();

        objEndereco.setCep(texto("Insira o CEP"));
        objEndereco.setLogradouro(texto("Insira o Logradouro"));
        objEndereco.setBairro(texto("Insira o Bairro"));
        objEndereco.setNumero(inteiro("Insira o Número"));
        objEndereco.setComplemento(texto("Insira o Complemento"));
        objEndereco.setCidade(texto("Insira a Cidade"));
    }
}
