package com.api_produtos.request;

public class ProdutoRequest {
    private String nome;
    private String descricao;
    private Double preco;

    public void setNome(String nome, String descricao, Double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }
}
