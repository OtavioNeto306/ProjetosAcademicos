package br.fuj.exception;



/**
 * Projeto Ammamentar / Faculdade Unijorge Materia (Projetor integrador)
 * @author Otávio Neto 
 * Classe Responsavel por fazer o tratamento de erro
 */
public class ErroSistema extends Exception {

    public ErroSistema(String message) {
        super(message);
    }

    public ErroSistema(String message, Throwable cause) {
        super(message, cause);
    }
    
}
