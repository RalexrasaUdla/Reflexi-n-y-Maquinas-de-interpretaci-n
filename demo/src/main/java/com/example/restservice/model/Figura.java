package com.example.restservice.model;

import java.util.Map;

public interface Figura {
    void inicializar(Map<String, Object> parametros);
    double calcularArea();
    double calcularPerimetro();
}