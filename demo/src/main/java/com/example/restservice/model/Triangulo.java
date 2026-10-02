package com.example.restservice.model;

import java.util.Map;

public class Triangulo implements Figura {
    private double base;
    private double altura;
    private double lado1;
    private double lado2;
    private double lado3;

    @Override
    public void inicializar(Map<String, Object> parametros) {
        this.base = Double.parseDouble(parametros.get("base").toString());
        this.altura = Double.parseDouble(parametros.get("altura").toString());
        this.lado1 = Double.parseDouble(parametros.get("lado1").toString());
        this.lado2 = Double.parseDouble(parametros.get("lado2").toString());
        this.lado3 = Double.parseDouble(parametros.get("lado3").toString());
    }

    @Override
    public double calcularArea() {
        return (base * altura)/2;
    }

    @Override
    public double calcularPerimetro() {
        return lado1+lado2+lado3;
    }
}