package com.api_produtos.controller;

import com.api_produtos.construtor.Produto;
import com.api_produtos.exceptions.ProdutoNaoEncontradoException;
import com.api_produtos.request.ProdutoRequest;
import com.api_produtos.service.BuscarProdutoService;
import com.api_produtos.service.ListaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final BuscarProdutoService buscarProdutoService;
    private final ListaProdutoService listaProdutoService;

    @Autowired
    public ProdutoController(BuscarProdutoService buscarProdutoService, ListaProdutoService listaProdutoService) {
        this.buscarProdutoService = buscarProdutoService;
        this.listaProdutoService = listaProdutoService;
    }

    @GetMapping("/buscar")
    public Produto buscarProduto(@RequestBody ProdutoRequest produtoRequest) {
        String nome = produtoRequest.getNome();
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio");
        }
        Produto produto = buscarProdutoService.buscarProdutoPorNome(nome);
        if (produto == null) {
            throw new ProdutoNaoEncontradoException(nome);
        }
        return produto;
    }

    @GetMapping("/todos")
    public List<Produto> buscarTodosProdutos() {
        return listaProdutoService.buscarTodosProdutos();
    }
}
