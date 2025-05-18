package br.com.fiap.bo;

import br.com.fiap.beans.TextToSpeech;
import br.com.fiap.dao.TextToSpeechDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class TextToSpeechBO {

    TextToSpeechDAO ttsDao;

    public ArrayList<TextToSpeech> selecionarBO() throws SQLException, ClassNotFoundException {
        ttsDao = new TextToSpeechDAO();
        return (ArrayList<TextToSpeech>) ttsDao.selecionar();
    }

    public void inserirBO(TextToSpeech tts) throws SQLException, ClassNotFoundException {
        TextToSpeechDAO ttsDao = new TextToSpeechDAO();
        ttsDao.inserir(tts);
    }

    public void atualizarBO(TextToSpeech tts) throws SQLException, ClassNotFoundException {
        TextToSpeechDAO ttsDao = new TextToSpeechDAO();
        ttsDao.atualizar(tts);
    }

    public void deletarBO(String idiomaTraduzido) throws SQLException, ClassNotFoundException {
       TextToSpeechDAO ttsDao = new TextToSpeechDAO();
        ttsDao.deletar(idiomaTraduzido);
    }
}
