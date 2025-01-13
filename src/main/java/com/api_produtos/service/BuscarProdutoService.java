package com.api_produtos.service;

import com.api_produtos.construtor.Produto;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class BuscarProdutoService {
    private final Map<String, Produto> produtos;

    public BuscarProdutoService() {
        this.produtos = new HashMap<>();
        carregarProdutosDoArquivo();
    }

    private void carregarProdutosDoArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(
                "src\\main\\products\\products.txt"))) {

            String linha;
            Produto produto = null;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) {
                    if (produto != null) {
                        produtos.put(produto.getNome(), produto);
                    }
                    produto = null;
                } else if (linha.startsWith("Nome:")) {
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Produto buscarProdutoPorNome(String nome) {
        return produtos.get(nome);
    }
}
