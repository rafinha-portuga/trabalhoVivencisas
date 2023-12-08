package com.example.amigoProRim.controller;

import com.example.amigoProRim.model.Cupom;
import com.example.amigoProRim.model.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cupons")
public class CupomController {

    @Autowired
    private CupomRepository cupomRepository;

    @GetMapping
    public List<Cupom> listarCupons() {
        return cupomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cupom> buscarCupom(@PathVariable int id) {
        return cupomRepository.findById(id);
    }

    @PostMapping
    public Cupom criarCupom(@RequestBody Cupom cupom) {
        return cupomRepository.save(cupom);
    }

    @PutMapping("/{id}")
    public Cupom atualizarCupom(@PathVariable int id, @RequestBody Cupom cupomAtualizado) {
        cupomAtualizado.setIdCupom(id);
        return cupomRepository.save(cupomAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarCupom(@PathVariable int id) {
        cupomRepository.deleteById(id);
    }
}
