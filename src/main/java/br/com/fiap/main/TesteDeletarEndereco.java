package br.com.fiap.main;

import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EnderecoDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarEndereco {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Endereco objEndereco = new Endereco();

        EnderecoDAO objEnderecoDAO = new EnderecoDAO();

       objEndereco.setCep(texto("Informe o CEP do endereço a ser deletado"));

        System.out.println(objEnderecoDAO.deletar(objEndereco.getCep()));
    }
}
