package br.com.fiap.main;

import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EnderecoDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarEndereco {

        static String texto(String j) {
            return JOptionPane.showInputDialog(j);
        }

        static int inteiro(String j) {
            return Integer.parseInt(JOptionPane.showInputDialog(j));
        }

        public static void main(String[] args) throws SQLException, ClassNotFoundException {

            Endereco objEndereco = new Endereco();
            EnderecoDAO enderecoDAO = new EnderecoDAO();


            objEndereco.setCep(texto("Atualize o CEP"));
            objEndereco.setLogradouro(texto("Atualize o Logradouro"));
            objEndereco.setBairro(texto("Atualize o Bairro"));
            objEndereco.setNumero(inteiro("Atualize o Número"));
            objEndereco.setComplemento(texto("Atualize o Complemento"));
            objEndereco.setCidade(texto("Atualize a Cidade"));

            System.out.println(enderecoDAO.atualizar(objEndereco));
        }
    }


