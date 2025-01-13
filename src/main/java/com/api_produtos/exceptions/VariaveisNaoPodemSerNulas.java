package com.api_produtos.exceptions;

public class VariaveisNaoPodemSerNulas extends RuntimeException {
    public VariaveisNaoPodemSerNulas
            (String message, String descricao, double preco){

        super("Algumas de suas VARIAVEIS tem valores nulos " + message);
    }
}
