package br.com.fiap.bo;

import br.com.fiap.beans.Estacao;
import br.com.fiap.dao.EstacaoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class EstacaoBO {

    EstacaoDAO estacaoDao;

    public ArrayList<Estacao> selecionarBO() throws SQLException, ClassNotFoundException {
        estacaoDao = new EstacaoDAO();
        return (ArrayList<Estacao>) estacaoDao.selecionar();
    }

    public void inserirBO(Estacao estacao) throws SQLException, ClassNotFoundException {
        estacaoDao = new EstacaoDAO();
        estacaoDao.inserir(estacao);
    }

    public void atualizarBO(Estacao estacao) throws SQLException, ClassNotFoundException {
        estacaoDao = new EstacaoDAO();
        estacaoDao.atualizar(estacao);
    }

    public void deletarBO(int idEstacao) throws SQLException, ClassNotFoundException {
        estacaoDao = new EstacaoDAO();
        estacaoDao.deletar(idEstacao);
    }
}
