package com.api_futebol.service;

import com.api_futebol.construtor.Produto;

import java.io.*;
import java.util.*;

public class ProdutoService {
    private Map<String, Produto> produtos;

    public ProdutoService() {
        this.produtos = new HashMap<>();
        carregarProdutosDoArquivo();
    }

    private void carregarProdutosDoArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader
                ("C:\\Users\\matheus.fgs\\Desktop\\api_produtos\\src" +
                        "\\main\\products\\products.txt"))) {

            String linha;
            Produto produto = null;

            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Nome:")) {
                    if (produto != null) {
                        produtos.put(produto.getNome(), produto);
                    }
                    produto = new Produto();
                    produto.setNome(linha.substring(5).trim());
                } else if (linha.startsWith("Descricao:")) {
                    if (produto != null) {
                        produto.setDescricao(linha.substring(10).trim());
                    }
                } else if (linha.startsWith("Preco:")) {
                    if (produto != null) {
                        produto.setPreco(Double.parseDouble(linha.substring(6).trim()));
                    }
                }
            }
            if (produto != null) {
                produtos.put(produto.getNome(), produto);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Produto buscarProdutoPorNome(String nome) {
        return produtos.get(nome);
    }
}
