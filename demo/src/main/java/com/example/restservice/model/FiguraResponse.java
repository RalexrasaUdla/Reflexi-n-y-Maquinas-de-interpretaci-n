package com.example.restservice.model;

public class FiguraResponse {
    private String nombre;
    private double area;
    private double perimetro;

    public FiguraResponse(String nombre, double area, double perimetro) {
        this.nombre = nombre;
        this.area = area;
        this.perimetro = perimetro;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public double getArea() { return area; }
    public double getPerimetro() { return perimetro; }
}