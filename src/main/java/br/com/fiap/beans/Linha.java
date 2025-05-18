package br.com.fiap.beans;

public class Linha {
    private int idLinha;
    private String nome;
    private String cor;

    public Linha() {
        super();
    }

    public Linha(int idLinha, String nome, String cor) {
        this.idLinha = idLinha;
        this.nome = nome;
        this.cor = cor;
    }

    public int getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(int idLinha) {
        this.idLinha = idLinha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Linha:" +
                "\nidLinha=" + idLinha +
                "\nnome='" + nome + '\'' +
                "\ncor='" + cor + '\'' +
                '.';
    }
}
