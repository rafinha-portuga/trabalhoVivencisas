package com.example.amigoProRim.model;

import jakarta.persistence.*;

@Entity
public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCupom;

    @ManyToOne
    @JoinColumn(name = "idLoja", referencedColumnName = "idLoja")
    private Loja loja;

    @ManyToOne
    @JoinColumn(name = "idProduto", referencedColumnName = "idProduto")
    private Produto produto;

    private String codigoCupom;
    private double descontoPercentual;

    public int getIdCupom() {
        return idCupom;
    }

    public void setIdCupom(int idCupom) {
        this.idCupom = idCupom;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getCodigoCupom() {
        return codigoCupom;
    }

    public void setCodigoCupom(String codigoCupom) {
        this.codigoCupom = codigoCupom;
    }

    public double getDescontoPercentual() {
        return descontoPercentual;
    }

    public void setDescontoPercentual(double descontoPercentual) {
        this.descontoPercentual = descontoPercentual;
    }

}
