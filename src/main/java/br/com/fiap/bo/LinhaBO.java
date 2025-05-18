package br.com.fiap.bo;

import br.com.fiap.beans.Linha;
import br.com.fiap.dao.LinhaDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class LinhaBO {

    LinhaDAO linhaDao;

    public ArrayList<Linha> selecionarBO() throws SQLException, ClassNotFoundException {
        linhaDao = new LinhaDAO();
        return (ArrayList<Linha>) linhaDao.selecionar();
    }

    public void inserirBO(Linha linha) throws SQLException, ClassNotFoundException {
        linhaDao = new LinhaDAO();
        linhaDao.inserir(linha);
    }

    public void atualizarBO(Linha linha) throws SQLException, ClassNotFoundException {
        linhaDao = new LinhaDAO();
        linhaDao.atualizar(linha);
    }

    public void deletarBO(int idLinha) throws SQLException, ClassNotFoundException {
        linhaDao = new LinhaDAO();
        linhaDao.deletar(idLinha);
    }
}
