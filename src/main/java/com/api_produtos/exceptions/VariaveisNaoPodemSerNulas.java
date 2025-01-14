package com.api_produtos.exceptions;

public class VariaveisNaoPodemSerNulas extends RuntimeException {
    public VariaveisNaoPodemSerNulas
            (String message){

        super("Algumas de suas VARIAVEIS tem valores nulos " + message);
    }
}
