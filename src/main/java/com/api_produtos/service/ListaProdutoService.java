package com.api_produtos.service;

import com.api_produtos.construtor.Produto;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ListaProdutoService {

    private final List<Produto> produtos;

    public ListaProdutoService() {
        this.produtos = new ArrayList<>();
        carregarProdutosDoArquivo();
    }

    private void carregarProdutosDoArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(
                "src/main/products/products.txt"))) {

            String linha;
            Produto produto = null;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) {
                    if (produto != null) {
                        produtos.add(produto);
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

            if (produto != null) {
                produtos.add(produto);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> buscarTodosProdutos() {
        return new ArrayList<>(produtos);
    }
}