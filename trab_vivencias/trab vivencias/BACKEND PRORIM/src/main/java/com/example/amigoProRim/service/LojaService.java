package com.example.amigoProRim.service;


import com.example.amigoProRim.model.Loja;
import com.example.amigoProRim.model.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    public List<Loja> listarTodasLojas() {
        return lojaRepository.findAll();
    }

    public Optional<Loja> buscarLojaPorId(int id) {
        return lojaRepository.findById(id);
    }

    public Loja criarOuAtualizarLoja(Loja loja) {
        return lojaRepository.save(loja);
    }

    public void deletarLoja(int id) {
        lojaRepository.deleteById(id);
    }
}
