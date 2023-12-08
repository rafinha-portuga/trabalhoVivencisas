package com.example.amigoProRim.controller;


import com.example.amigoProRim.model.Loja;
import com.example.amigoProRim.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lojas")
public class LojaController {

    @Autowired
    private LojaService lojaService;

    @GetMapping
    public List<Loja> listarLojas() {
        return lojaService.listarTodasLojas();
    }

    @GetMapping("/{id}")
    public Optional<Loja> buscarLoja(@PathVariable int id) {
        return lojaService.buscarLojaPorId(id);
    }

    @PostMapping
    public Loja criarLoja(@RequestBody Loja loja) {
        return lojaService.criarOuAtualizarLoja(loja);
    }

    @PutMapping("/{id}")
    public Loja atualizarLoja(@PathVariable int id, @RequestBody Loja lojaAtualizada) {
        lojaAtualizada.setIdLoja(id);
        return lojaService.criarOuAtualizarLoja(lojaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarLoja(@PathVariable int id) {
        lojaService.deletarLoja(id);
    }
}
