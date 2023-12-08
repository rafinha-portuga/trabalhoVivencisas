package com.example.amigoProRim.service;


import com.example.amigoProRim.model.Produto;
import com.example.amigoProRim.model.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(int id) {
        return produtoRepository.findById(id);
    }

    public Produto criarOuAtualizarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(int id) {
        produtoRepository.deleteById(id);
    }
}
