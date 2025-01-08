package com.api_futebol.controller;

import com.api_futebol.construtor.Produto;
import com.api_futebol.exceptions.ProdutoNaoEncontradoException;
import com.api_futebol.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController() {
        this.produtoService = new ProdutoService();
    }

    @GetMapping("/buscar")
    public Produto buscarProduto(@RequestBody Map<String, String> request) {
        String nomeProduto = request.get("nome");
        Produto produto = produtoService.buscarProdutoPorNome(nomeProduto);
        if (produto == null) {
            throw new ProdutoNaoEncontradoException(nomeProduto);
        }
        return produto;
    }
}