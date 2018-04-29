package com.example.algamoneyapi.exceptionhandler;

/**
 * @author vitor
 *
 * created on 2018-03-12
 */
public class Erro {

    private String mensagemUsuario;
    private String mensagemDesenvolvedor;

    public Erro(String mensagemUsuario, String mensagemDesenvolvedor) {
        this.mensagemUsuario = mensagemUsuario;
        this.mensagemDesenvolvedor = mensagemDesenvolvedor;
    }

    /**
     * @return the mensagemUsuario
     */
    public String getMensagemUsuario() {
        return mensagemUsuario;
    }

    /**
     * @return the mensagemDesenvolvedor
     */
    public String getMensagemDesenvolvedor() {
        return mensagemDesenvolvedor;
    }
}
