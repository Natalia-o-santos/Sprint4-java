package br.com.fiap.beans;

public class Estacao {
    private int idEstacaoo;
    private String nomeEstacao;
    private String conexoes;
    private Endereco endereco;

    public Estacao() {
        super();
    }

    public Estacao(int idEstacaoo, String nomeEstacao, String conexoes) {
        this.idEstacaoo = idEstacaoo;
        this.nomeEstacao = nomeEstacao;
        this.conexoes = conexoes;
    }

    public int getIdEstacaoo() {
        return idEstacaoo;
    }

    public void setIdEstacaoo(int idEstacaoo) {
        this.idEstacaoo = idEstacaoo;
    }

    public String getNomeEstacao() {
        return nomeEstacao;
    }

    public void setNomeEstacao(String nomeEstacao) {
        this.nomeEstacao = nomeEstacao;
    }

    public String getConexoes() {
        return conexoes;
    }

    public void setConexoes(String conexoes) {
        this.conexoes = conexoes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Estacao:" +
                "\nidEstacaoo=" + idEstacaoo +
                "\nnomeEstacao='" + nomeEstacao + '\'' +
                "\nconexoes='" + conexoes + '\'' +
                "\n" + endereco +
                '.';
    }
}
