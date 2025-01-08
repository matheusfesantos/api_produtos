package com.api_produtos.controller;

import com.api_produtos.construtor.Produto;
import com.api_produtos.exceptions.ProdutoNaoEncontradoException;
import com.api_produtos.service.ListaProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ListaProdutoService produtoService;

    public ProdutoController() {
        this.produtoService = new ListaProdutoService();
    }

    @GetMapping("/buscar")
    public Produto buscarProduto(@RequestParam String nome) {
        Produto produto = produtoService.buscarProdutoPorNome(nome);
        if (produto == null) {
            throw new ProdutoNaoEncontradoException(nome);
        }
        return produto;
    }

    @GetMapping("/todos")
    public List<Produto> buscarTodosProdutos() {
        return produtoService.buscarTodosProdutos();
    }
}