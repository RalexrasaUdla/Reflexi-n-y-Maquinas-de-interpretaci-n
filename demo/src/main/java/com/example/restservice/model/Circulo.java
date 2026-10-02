package com.example.restservice.model;

import java.util.Map;

public class Circulo implements Figura {
    private double radio;

    @Override
    public void inicializar(Map<String, Object> parametros) {
        this.radio = Double.parseDouble(parametros.get("radio").toString());
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}