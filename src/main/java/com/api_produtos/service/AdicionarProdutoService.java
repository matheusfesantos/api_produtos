package com.api_produtos.service;

import com.api_produtos.construtor.Produto;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;

@Service
public class AdicionarProdutoService {

    private final String filePath = "src/main/products/products.txt";
    private final BuscarProdutoService buscarProdutoService;

    public AdicionarProdutoService(BuscarProdutoService buscarProdutoService) {
        this.buscarProdutoService = buscarProdutoService;
    }

    public Produto adicionarProduto(String nome, String descricao, double preco){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))){
            bw.newLine();
            bw.newLine();
            bw.write("Nome: " + nome + "\n");
            bw.write("Descricao: " + descricao + "\n");
            bw.write("Preco: " + preco);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return buscarProdutoService.buscarProdutoPorNome(nome);
    }
}