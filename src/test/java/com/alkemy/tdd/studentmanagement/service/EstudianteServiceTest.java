package com.alkemy.tdd.studentmanagement.service;

import com.alkemy.tdd.studentmanagement.model.Estudiante;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstudianteServiceTest {

    @Test
    void deberiaCrearEstudianteYAsignarId() {
        // ARRANGE (Preparar)
        EstudianteService estudianteService = new EstudianteService();
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombre("Juan");

        // ACT (Actuar)
        Estudiante estudianteGuardado = estudianteService.crearEstudiante(nuevoEstudiante);

        // ASSERT (Afirmar)
        assertNotNull(estudianteGuardado, "El estudiante guardado no debe ser nulo.");
        assertNotNull(estudianteGuardado.getId(), "El estudiante guardado debe tener un ID asignado.");
        assertEquals("Juan", estudianteGuardado.getNombre(), "El nombre del estudiante debe ser Juan.");
    }
}