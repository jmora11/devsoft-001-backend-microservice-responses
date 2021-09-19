package com.P001SpringBoot.back.respuestas.controller;

import com.P001SpringBoot.back.respuestas.models.entity.Respuesta;
import com.P001SpringBoot.back.respuestas.services.RespuestaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RespuestaControlller {

    @Autowired
    RespuestaServiceImpl respuestaService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Iterable<Respuesta> respuestas) {

        respuestas = ((List<Respuesta>) respuestas)
                .stream()
                .map(respuesta -> {
                    respuesta.setAlumnoId(respuesta.getStudent().getId());
                    respuesta.setPreguntaId(respuesta.getPregunta().getId());
                    return respuesta;
                }).collect(Collectors.toList());

        Iterable<Respuesta> respuestasDb = respuestaService.saveAll(respuestas);

        return ResponseEntity.status(HttpStatus.CREATED).body(respuestasDb);
    }

    @GetMapping("/student/{studentId}/exam/{examId}")
    public ResponseEntity<?> obtenerRespuestasPorAlumnoAndExam(@PathVariable Long studentId, @PathVariable Long examId) {
        Iterable<Respuesta> respuestas = respuestaService.findResponsesByStudentByExam(studentId, examId);
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/student/{studentId}/resolved-exams")
    public ResponseEntity<?> obtenerExamenesIdsConRespuestasAlumno(@PathVariable Long studentId) {
        Iterable<Long> examenesIds = respuestaService.findExamsWhithResponsesById(studentId);
        return ResponseEntity.ok(examenesIds);
    }
}
