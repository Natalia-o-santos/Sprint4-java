package br.com.fiap.bo;

import br.com.fiap.beans.AudioGuia;
import br.com.fiap.dao.AudioGuiaDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AudioGuiaBO {

    AudioGuiaDAO audioGuiaDao;

    public ArrayList<AudioGuia> selecionarBO() throws SQLException, ClassNotFoundException {
        audioGuiaDao = new AudioGuiaDAO();
        return (ArrayList<AudioGuia>) audioGuiaDao.selecionar();
    }

    public void inserirBO(AudioGuia audioGuia) throws SQLException, ClassNotFoundException {
        audioGuiaDao = new AudioGuiaDAO();
        audioGuiaDao.inserir(audioGuia);
    }

    public void atualizarBO(AudioGuia audioGuia, String idioma) throws SQLException, ClassNotFoundException {
        audioGuiaDao = new AudioGuiaDAO();
        audioGuiaDao.atualizar(audioGuia, idioma);
    }

    public void deletarBO(String idioma) throws SQLException, ClassNotFoundException {
        audioGuiaDao = new AudioGuiaDAO();
        audioGuiaDao.deletar(idioma);
    }
}

