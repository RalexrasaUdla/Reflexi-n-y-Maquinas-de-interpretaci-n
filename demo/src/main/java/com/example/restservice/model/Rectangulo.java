package com.example.restservice.model;

import java.util.Map;

public class Rectangulo implements Figura {
    private double base;
    private double altura;

    @Override
    public void inicializar(Map<String, Object> parametros) {
        this.base = Double.parseDouble(parametros.get("base").toString());
        this.altura = Double.parseDouble(parametros.get("altura").toString());
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}