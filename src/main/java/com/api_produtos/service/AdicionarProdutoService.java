package com.api_produtos.service;

import com.api_produtos.construtor.Produto;
import org.springframework.stereotype.Service;

@Service
public class AdicionarProdutoService {

    public Produto adicionarProduto(String nome, String descricao, double preco) {

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco(preco);



        return produto;
    }
}