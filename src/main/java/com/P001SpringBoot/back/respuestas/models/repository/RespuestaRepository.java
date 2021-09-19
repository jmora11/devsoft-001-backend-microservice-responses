package com.P001SpringBoot.back.respuestas.models.repository;

import com.P001SpringBoot.back.respuestas.models.entity.Respuesta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RespuestaRepository extends MongoRepository<Respuesta, String> {

    @Query("{'alumnoId': ?0, 'preguntaId': { $in: ?1 }}")
    public Iterable<Respuesta> findResponsesByStudentByQuestionsId(Long studentId, Iterable<Long> preguntaIds);

    @Query("{'alumnoId': ?0}")
    public Iterable<Respuesta> findByAlumnoId(Long alumnoId);

    @Query("{'alumnoId': ?0, 'pregunta.examen.id': ?1}")
    public Iterable<Respuesta> findResponsesByStudentByExam(Long studentId, Long examId);

    @Query(value = "{'alumnoId': ?0}", fields = "{'pregunta.examen.id': 1}")
    public Iterable<Respuesta> findExamsIdWithResponsesByStudent(Long studentId);


    // @Query("select r from Respuesta r join fetch r.pregunta p join fetch p.examen e where r.alumnoId=?1 and e.id=?2")
    // public Iterable<Respuesta> findResponsesByStudentByExam(Long studentId, Long examId);

    // @Query("select e.id from Respuesta r join r.pregunta p join p.examen e where r.alumnoId=?1 group by e.id")
    // public Iterable<Long> findExamsWhithResponsesById(Long studentId);
}
