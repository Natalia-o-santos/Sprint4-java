package br.com.fiap.main;

import br.com.fiap.beans.Endereco;
import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarUsuario {
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }
    static int inteiro(String j){
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    static double real(String j) {
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException,ClassNotFoundException{
        Usuario objUsuario = new Usuario();
        UsuarioDAO objUsuarioDAO = new UsuarioDAO();

        objUsuario.setCpf(texto("Informe o CPF do usuário a ser atualizado"));
        objUsuario.setNome(texto("Atualize o Nome"));
        objUsuario.setEmail(texto("Atualize o Email"));
        objUsuario.setDataNascimento(texto("Atualize a Data de Nascimento (YYYY-MM-DD)"));


        Endereco endereco = new Endereco();
        endereco.setCep(texto("Atualize o CEP"));
        endereco.setLogradouro(texto("Atualize o Logradouro"));
        endereco.setBairro(texto("Atualize o Bairro"));
        endereco.setNumero(inteiro("Atualize o Número"));
        endereco.setComplemento(texto("Atualize o Complemento"));
        endereco.setCidade(texto("Atualize a Cidade"));


        System.out.println(objUsuarioDAO.atualizar(objUsuario));
    }

}
