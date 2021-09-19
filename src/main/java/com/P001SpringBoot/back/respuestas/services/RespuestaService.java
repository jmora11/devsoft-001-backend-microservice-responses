package com.P001SpringBoot.back.respuestas.services;

import com.P001SpringBoot.back.respuestas.models.entity.Respuesta;

public interface RespuestaService {

    public  Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas);

    public Iterable<Respuesta> findResponsesByStudentByExam(Long studentId, Long examId);

    public Iterable<Long> findExamsWhithResponsesById(Long studentId);

    public Iterable<Respuesta> findByAlumnoId(Long alumnoId);
}
