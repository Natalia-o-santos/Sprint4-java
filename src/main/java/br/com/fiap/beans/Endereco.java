package br.com.fiap.beans;

public class Endereco {
    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;

    public Endereco() {
        super();
    }

    public Endereco(String logradouro, int numero, String complemento, String cep, String bairro, String cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String validarCEP() {
        if (this.cep.matches("\\d{5}-\\d{3}")) {
            return "CEP válido";
        } else {
            return "CEP inválido";}
    }

    @Override
    public String toString() {
        return "Endereço" +
                "\nlogradouro='" + logradouro + '\'' +
                "\nnumero=" + numero +
                "\ncomplemento='" + complemento + '\'' +
                "\ncep='" + cep + '\'' +
                "\nbairro='" + bairro + '\'' +
                "\ncidade='" + cidade + '\'' +
                '.';
    }
}
