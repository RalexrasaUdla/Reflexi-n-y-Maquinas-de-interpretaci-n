package com.example.restservice.controller;

import com.example.restservice.model.FiguraResponse;
import com.example.restservice.service.FiguraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/figuras")
public class FiguraController {

    private final FiguraService figuraService;

    public FiguraController(FiguraService figuraService) {
        this.figuraService = figuraService;
    }

    @PostMapping("/{nombre}")
    public FiguraResponse calcularFigura(
            @PathVariable String nombre,
            @RequestBody Map<String, Object> parametros) throws Exception {
        return figuraService.crearFigura(nombre, parametros);
    }

    @PostMapping("/todas")
    public List<FiguraResponse> calcularTodas(
            @RequestBody Map<String, Map<String, Object>> datosFiguras) throws Exception {
        return figuraService.calcularTodasConMedidas(datosFiguras);
    }
}