package br.com.fiap.bo;

import br.com.fiap.beans.SpeechToText;
import br.com.fiap.dao.SpeechToTextDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SpeechToTextBO {

    SpeechToTextDAO speechDao;

    public ArrayList<SpeechToText> selecionarBO() throws SQLException, ClassNotFoundException {
       SpeechToTextDAO speechDao = new SpeechToTextDAO();
        return (ArrayList<SpeechToText>) speechDao.selecionar();
    }

    public void inserirBO(SpeechToText spt) throws SQLException, ClassNotFoundException {
        SpeechToTextDAO speechDao = new SpeechToTextDAO();
        speechDao.inserir(spt);
    }

    public void atualizarBO(SpeechToText speechToText) throws SQLException, ClassNotFoundException {
        speechDao = new SpeechToTextDAO();
        speechDao.atualizar(speechToText);
    }

    public void deletarBO(String idiomaFalado) throws SQLException, ClassNotFoundException {
        speechDao = new SpeechToTextDAO();
        speechDao.deletar(idiomaFalado);
    }
}
