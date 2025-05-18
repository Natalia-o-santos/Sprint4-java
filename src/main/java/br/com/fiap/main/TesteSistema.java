package br.com.fiap.main;

import br.com.fiap.beans.*;

import javax.swing.*;
import java.util.ArrayList;

public class TesteSistema {

    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j ){
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) {

        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();

        Usuario objUsuario = null;
        Endereco objEndereco = null;

        do{
            objUsuario = new Usuario();
            objUsuario.setCpf(texto("CPF: "));
            objUsuario.setNome(texto("Nome: "));
            objUsuario.setEmail(texto("Email: "));
            objUsuario.setDataNascimento(texto("Data de nascimento: "));

            Endereco objEndUsuario = new Endereco(
                    texto("Logradouro"),
                    inteiro("Número"),
                    texto("Complemento"),
                    texto("Cep"),
                    texto("Bairro"),
                    texto("Cidade")
            );
            System.out.println(objEndUsuario.validarCEP());
            objUsuario.setEndereco(objEndUsuario);

            listaUsuario.add(objUsuario);

        }while(JOptionPane.showConfirmDialog(null,
                "Cadastrar mais usuarios?",
                "Cadastro usuario", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE)==0);
        for (Usuario a : listaUsuario){
            System.out.println("\n\nCPF: " + a.getCpf()+
                    "\nNome: " + a.getNome()+
                    "\nEmail: " + a.getEmail() +
                    "\nData Nascimento: " + a.getDataNascimento());

            System.out.println(a.getEndereco());
        }


        //int brilho, int tamanhoFonte, String idioma
        Ajustes objAjustes  = new Ajustes(
                inteiro("Brilho"),
                inteiro("Tamanho da fonte"),
                texto("Idioma do Sistema")
        );
        //String idioma, int volume
        AudioGuia objAudioGuia = new AudioGuia(
                texto("Idioma do Audio"),
                inteiro("Volume")

        );


        TextToSpeech objTextToSpeech = new TextToSpeech(
                texto("Idioma Traduzido "),
                texto("Idioma Falado")
        );

        //String idiomaFalado, String idiomaEscrito)
        SpeechToText objSpeechToText = new SpeechToText(
                texto("Idioma Falado: "),
                texto("Idioma da Escrita")

        );
        //int idLinha, String nome, String cor
        Linha objLinha = new Linha(
                inteiro("Id da linha"),
                texto("Nome da linha"),
                texto("Cor")
        );
        //int idEstacaoo, String nomeEstacao, String conexoes
        Estacao objEstacao = new Estacao(
                inteiro("Id Estação"),
                texto(" Nome Estação")    ,
                texto("Conexões")
        );
//String logradouro, int numero, String complemento, String cep, String bairro, String cidade
        Endereco objEndEstacao = new Endereco(
                texto("Logradouro"),
                inteiro("Numero"),
                texto("Complemento"),
                texto("Cep"),
                texto("Bairro"),
                texto("Cidade")
        );
        System.out.println(objEndEstacao.validarCEP());
        objEstacao.setEndereco(objEndEstacao);


        System.out.println(
                objUsuario + "\n\n" +  objAjustes + "\n\n" + objAudioGuia + "\n\n" + objTextToSpeech + "\n\n" + objSpeechToText+ "\n\n" + objLinha + "\n\n" + objEstacao      );

    }
}

