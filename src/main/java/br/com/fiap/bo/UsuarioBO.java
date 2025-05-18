package br.com.fiap.bo;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioBO {

        UsuarioDAO usuarioDao;

        public ArrayList<Usuario> selecionarBO() throws SQLException, ClassNotFoundException {
            usuarioDao = new UsuarioDAO();
            return (ArrayList<Usuario>) usuarioDao.selecionar();
        }

        public void inserirBO(Usuario usuario) throws SQLException, ClassNotFoundException {
            usuarioDao = new UsuarioDAO();
            usuarioDao.inserir(usuario);
        }

        public void atualizarBO(Usuario usuario) throws SQLException, ClassNotFoundException {
            usuarioDao = new UsuarioDAO();
            usuarioDao.atualizar(usuario);
        }

        public void deletarBO(String cpf) throws SQLException, ClassNotFoundException {
            usuarioDao = new UsuarioDAO();
            usuarioDao.deletar(cpf);
        }
    }


