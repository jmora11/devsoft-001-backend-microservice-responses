package com.P001SpringBoot.back.respuestas.clients;

import com.P001SpringBoot.back.models.entity.Examen;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "microservicio-examenes")
public interface ExamenFeingClient {

    @GetMapping({"/find/{id}"})
    public Examen obtenerExamenPorId(@PathVariable Long id);

    @GetMapping("/answered-by-questions")
    public List<Long> obtenerExamenesRespondidosPorPreguntasIdRespondidas(@RequestParam List<Long> preguntaIds);
}
