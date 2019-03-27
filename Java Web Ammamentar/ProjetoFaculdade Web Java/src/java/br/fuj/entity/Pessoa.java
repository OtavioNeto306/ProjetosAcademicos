/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fuj.entity;

import java.util.Objects;

/**
 * Projeto Ammamentar / Faculdade Unijorge Materia (Projetor integrador)
 * @author Otávio Neto 
 * Classe Responsavel por Salvar os Registro na Aplicação
 */
public class Pessoa {
    
    private Integer idCadastroPessoa;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String email;
    private String senha;
    private Endereco endereco;

    public Pessoa() {
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Pessoa(Endereco endereco) {
        this.endereco = endereco;
    }

    public Pessoa(Integer idCadastroPessoa, String nome, String cpf, String rg, String telefone, String rua, String bairro, String estado, String numero, String cidade, String cep, String pontoReferencia, String email, String senha) {
        this.idCadastroPessoa = idCadastroPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;    
        this.email = email;
        this.senha = senha;
    }

    public Pessoa(int aInt, String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {

    }

    

   
    public Integer getIdCadastroPessoa() {
        return idCadastroPessoa;
    }

    public void setIdCadastroPessoa(Integer idCadastroPessoa) {
        this.idCadastroPessoa = idCadastroPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.idCadastroPessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.idCadastroPessoa, other.idCadastroPessoa)) {
            return false;
        }
        return true;
    }

    
}
