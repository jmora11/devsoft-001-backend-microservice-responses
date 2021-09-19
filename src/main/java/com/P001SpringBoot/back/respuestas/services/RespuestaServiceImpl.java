package com.P001SpringBoot.back.respuestas.services;

import com.P001SpringBoot.back.respuestas.models.entity.Respuesta;
import com.P001SpringBoot.back.respuestas.models.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespuestaServiceImpl implements RespuestaService{

    @Autowired
    private RespuestaRepository repository;

    @Override
    public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
        return repository.saveAll(respuestas);
    }

    @Override
    public Iterable<Respuesta> findResponsesByStudentByExam(Long studentId, Long examId) {

        List<Respuesta> respuestas = (List<Respuesta>) repository.findResponsesByStudentByExam(studentId, examId);

        return respuestas;
    }

    @Override
    public Iterable<Long> findExamsWhithResponsesById(Long studentId) {

        List <Respuesta> respuestasAlumno = (List<Respuesta>) repository.findExamsIdWithResponsesByStudent(studentId);
        List <Long> examensIds = respuestasAlumno.stream()
                .map(respuesta -> respuesta.getPregunta()
                    .getExamen()
                    .getId())
                    .distinct()
                    .collect(Collectors.toList());
        return examensIds;
    }

    @Override
    public Iterable<Respuesta> findByAlumnoId(Long alumnoId) {
        return repository.findByAlumnoId(alumnoId);
    }
}
