package br.com.fiap.bo;

import br.com.fiap.beans.Ajustes;
import br.com.fiap.dao.AjustesDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AjustesBO {

    AjustesDAO ajustesDao;

    public ArrayList<Ajustes> selecionarBO() throws SQLException, ClassNotFoundException {
        ajustesDao = new AjustesDAO();
        return (ArrayList<Ajustes>) ajustesDao.selecionar();
    }

    public void inserirBO(Ajustes ajustes) throws SQLException, ClassNotFoundException {
        ajustesDao = new AjustesDAO();
        ajustesDao.inserir(ajustes);
    }

    public void atualizarBO(Ajustes ajustes, String idioma) throws SQLException, ClassNotFoundException {
        ajustesDao = new AjustesDAO();
        ajustesDao.atualizar(ajustes, idioma);
    }

    public void deletarBO(String idioma) throws SQLException, ClassNotFoundException {
        ajustesDao = new AjustesDAO();
        ajustesDao.deletar(idioma);
    }
}
