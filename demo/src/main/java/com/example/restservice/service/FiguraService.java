package com.example.restservice.service;
import com.example.restservice.model.Circulo;
import com.example.restservice.model.Rectangulo;
import com.example.restservice.model.Triangulo;
import groovy.lang.GroovyClassLoader;
import com.example.restservice.model.Figura;
import com.example.restservice.model.FiguraResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FiguraService {

    private final Map<String, Class<?>> registroClases = new HashMap<>();

    public FiguraService() {
        registroClases.put("Circulo", Circulo.class);
        registroClases.put("Rectangulo", Rectangulo.class);
        registroClases.put("Triangulo", Triangulo.class);
    }

    public FiguraResponse crearFigura(String nombreFigura, Map<String, Object> parametros) throws Exception {
        Class<?> claseFigura = registroClases.get(nombreFigura);

        Figura figura = (Figura) claseFigura.getDeclaredConstructor().newInstance();
        figura.inicializar(parametros);

        return new FiguraResponse(
            nombreFigura,
            figura.calcularArea(),
            figura.calcularPerimetro()
        );
    }

    public List<FiguraResponse> calcularTodasConMedidas(Map<String, Map<String, Object>> figurasConParametros) throws Exception {
        List<FiguraResponse> listaRespuestas = new ArrayList<>();

        for (Map.Entry<String, Map<String, Object>> entry : figurasConParametros.entrySet()) {
            String nombreFigura = entry.getKey();
            Map<String, Object> parametros = entry.getValue();

            FiguraResponse respuesta = crearFigura(nombreFigura, parametros);
            listaRespuestas.add(respuesta);
        }
        return listaRespuestas;
    }

    public String registrarFiguraGroovy(String codigoGroovy) throws Exception {
        
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try (GroovyClassLoader loader = new GroovyClassLoader(classLoader)) {
            Class<?> groovyClass = loader.parseClass(codigoGroovy);

            if (!Figura.class.isAssignableFrom(groovyClass)) {
                throw new IllegalArgumentException("La clase enviada no implementa la interfaz Figura.");
            }

            String nombreClase = groovyClass.getSimpleName();
            registroClases.put(nombreClase, groovyClass);

            return "Figura '" + nombreClase + "' registrada correctamente con Groovy.";
        }
    }

    public Map<String, Class<?>> getRegistroClases() {
        return registroClases;
    }
}