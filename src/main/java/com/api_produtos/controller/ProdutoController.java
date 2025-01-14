package com.api_produtos.controller;

import com.api_produtos.construtor.Produto;
import com.api_produtos.exceptions.ProdutoNaoEncontradoException;
import com.api_produtos.exceptions.VariaveisNaoPodemSerNulas;
import com.api_produtos.request.ProdutoRequest;
import com.api_produtos.service.AdicionarProdutoService;
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
    private final AdicionarProdutoService adicionarProdutoService;

    @Autowired
    public ProdutoController
            (BuscarProdutoService buscarProdutoService,
             ListaProdutoService listaProdutoService,
             AdicionarProdutoService adicionarProdutoService){

        this.buscarProdutoService = buscarProdutoService;
        this.listaProdutoService = listaProdutoService;
        this.adicionarProdutoService = adicionarProdutoService;
    }

    @GetMapping("/buscar")
    public Produto buscarProduto(@RequestBody ProdutoRequest produtoRequest) {
        String nome = produtoRequest.getNome();

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio");
        }

        Produto produtoBuscar;
        produtoBuscar = buscarProdutoService.buscarProdutoPorNome(nome);

        if (produtoBuscar == null) {
            throw new ProdutoNaoEncontradoException(nome);
        }
        return produtoBuscar;
    }

    @GetMapping("/todos")
    public List<Produto> buscarTodosProdutos() {
        return listaProdutoService.buscarTodosProdutos();

    }

    @PostMapping("/adicionar")
    public Produto adicionarProduto(@RequestBody Produto produto) {
        String nome = produto.getNome();
        String descricao = produto.getDescricao();
        double preco = produto.getPreco();

        if (nome == null || descricao == null || preco == 0){
            throw new VariaveisNaoPodemSerNulas(nome, descricao, preco);
        }

        Produto produtoAdicionar;
        produtoAdicionar = adicionarProdutoService.adicionarProduto
                (nome, descricao, preco);

        return produtoAdicionar;
    }
}
