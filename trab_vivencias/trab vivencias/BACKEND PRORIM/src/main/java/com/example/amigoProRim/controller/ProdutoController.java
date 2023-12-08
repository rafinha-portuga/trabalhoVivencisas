package com.example.amigoProRim.controller;


import com.example.amigoProRim.model.Produto;
import com.example.amigoProRim.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarProduto(@PathVariable int id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.criarOuAtualizarProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable int id, @RequestBody Produto produtoAtualizado) {
        produtoAtualizado.setIdProduto(id);
        return produtoService.criarOuAtualizarProduto(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable int id) {
        produtoService.deletarProduto(id);
    }
}
