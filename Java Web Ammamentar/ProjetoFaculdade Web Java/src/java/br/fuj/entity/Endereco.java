
package br.fuj.entity;

/**
 * Projeto Ammamentar / Faculdade Unijorge Materia (Projetor integrador)
 * @author Otávio Neto 
 * Classe Responsavel por Salvar os Registro na Aplicação
 */

public class Endereco {
    

    private Integer id_endereco;
    private Pessoa pessoa;
    private String rua;
    private String bairro;
    private String estado;
    private String numero;
    private String cidade;
    private String cep;
    private String pontoReferencia;

    public Endereco() {
    }

    public Endereco(Integer id_endereco, Pessoa pessoa, String rua, String bairro, String estado, String numero, String cidade, String cep, String pontoReferencia) {
        this.id_endereco = id_endereco;
        this.pessoa = pessoa;
        this.rua = rua;
        this.bairro = bairro;
        this.estado = estado;
        this.numero = numero;
        this.cidade = cidade;
        this.cep = cep;
        this.pontoReferencia = pontoReferencia;
    }

   
    
    
    public Integer getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Integer id_endereco) {
        this.id_endereco = id_endereco;
    }

   
    

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    
    
    
}
