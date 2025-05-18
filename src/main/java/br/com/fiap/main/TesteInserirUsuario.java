package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteInserirUsuario {

    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j ){
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Usuario objUsuario = new Usuario();
        UsuarioDAO objUsuarioDAO= new UsuarioDAO();

        objUsuario.setCpf(texto("Informe CPF:"));
        objUsuario.setNome(texto("Nome: "));
        objUsuario.setEmail(texto("Insira o email:"));
        objUsuario.setDataNascimento(texto("Insira data de nascimento:"));
        System.out.println(objUsuarioDAO.inserir(objUsuario));

    }
}
