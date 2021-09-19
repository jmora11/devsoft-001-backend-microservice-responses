package com.P001SpringBoot.back.respuestas.models.entity;

import com.P001SpringBoot.back.models.entity.Student;
import com.P001SpringBoot.back.models.entity.Pregunta;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "respuestas")
public class Respuesta {

    @Id
    private String id;

    private String texto;

    //@Transient
    private Student student;

    private Long alumnoId;

    //@Transient
    private Pregunta pregunta;

    private Long preguntaId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Student getStudent() {
        return student;
    }

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }
}
