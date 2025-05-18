package br.com.fiap.bo;

import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EnderecoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoBO {

    EnderecoDAO enderecoDao;

    public ArrayList<Endereco> selecionarBO() throws SQLException, ClassNotFoundException {
        enderecoDao = new EnderecoDAO();
        return (ArrayList<Endereco>) enderecoDao.selecionar();
    }

    public void inserirBO(Endereco endereco) throws SQLException, ClassNotFoundException {
        enderecoDao = new EnderecoDAO();
        enderecoDao.inserir(endereco);
    }

    public void atualizarBO(Endereco endereco) throws SQLException, ClassNotFoundException {
        enderecoDao = new EnderecoDAO();
        enderecoDao.atualizar(endereco);
    }

    public void deletarBO(String cep) throws SQLException, ClassNotFoundException {
        enderecoDao = new EnderecoDAO();
        enderecoDao.deletar(cep);
    }
}
