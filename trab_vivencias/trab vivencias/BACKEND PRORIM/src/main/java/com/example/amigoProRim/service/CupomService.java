package com.example.amigoProRim.service;

import com.example.amigoProRim.model.Cupom;
import com.example.amigoProRim.model.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CupomService {

    @Autowired
    private CupomRepository cupomRepository;

    public List<Cupom> listarTodosCupons() {
        return cupomRepository.findAll();
    }

    public Optional<Cupom> buscarCupomPorId(int id) {
        return cupomRepository.findById(id);
    }

    public Cupom criarOuAtualizarCupom(Cupom cupom) {
        return cupomRepository.save(cupom);
    }

    public void deletarCupom(int id) {
        cupomRepository.deleteById(id);
    }
}
