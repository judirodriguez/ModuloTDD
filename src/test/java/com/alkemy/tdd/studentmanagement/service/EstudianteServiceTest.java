package com.alkemy.tdd.studentmanagement.service;

import com.alkemy.tdd.studentmanagement.model.Estudiante;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EstudianteServiceTest {

    @Test
    void deberiaCrearEstudianteYAsignarId() {
        EstudianteService estudianteService = new EstudianteService();
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombre("Juan");

        Estudiante estudianteGuardado = estudianteService.crearEstudiante(nuevoEstudiante);

        assertNotNull(estudianteGuardado, "El estudiante guardado no debe ser nulo.");
        assertNotNull(estudianteGuardado.getId(), "El estudiante guardado debe tener un ID asignado.");
        assertEquals("Juan", estudianteGuardado.getNombre(), "El nombre del estudiante debe ser Juan.");
    }

    @Test
    void deberiaLanzarExcepcionCuandoNombreEsNulo() {
        // ARRANGE (Preparar)
        EstudianteService estudianteService = new EstudianteService();
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombre(null); // Intencionalmente establecemos el nombre como nulo

        // ACT & ASSERT (Actuar y Afirmar)
        // Esperamos que se lance una IllegalArgumentException
        // El mensaje de la excepción es opcional, pero útil para claridad.
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            estudianteService.crearEstudiante(nuevoEstudiante);
        }, "Se esperaba una IllegalArgumentException cuando el nombre es nulo.");

        assertEquals("El nombre del estudiante es requerido.", thrown.getMessage(),
                "El mensaje de la excepción debe ser 'El nombre del estudiante es requerido.'");
    }

    @Test
    void deberiaLanzarExcepcionCuandoNombreEsVacio() {
        // ARRANGE (Preparar)
        EstudianteService estudianteService = new EstudianteService();
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombre(""); // Intencionalmente establecemos el nombre como vací

        // ACT & ASSERT (Actuar y Afirmar)
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            estudianteService.crearEstudiante(nuevoEstudiante);
        }, "Se esperaba una IllegalArgumentException cuando el nombre es vacío.");

        assertEquals("El nombre del estudiante es requerido.", thrown.getMessage(),
                "El mensaje de la excepción debe ser 'El nombre del estudiante es requerido.'");
    }

    @Test
    void deberiaCrearEstudianteConTodasLasPropiedadesYAsignarId() {

        EstudianteService estudianteService = new EstudianteService();
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombre("Ana");
        nuevoEstudiante.setApellido("Lopez");
        nuevoEstudiante.setEmail("ana.lopez@example.com");
        nuevoEstudiante.setFechaNacimiento(LocalDate.of(2000, 5, 15));

        Estudiante estudianteGuardado = estudianteService.crearEstudiante(nuevoEstudiante);

        assertNotNull(estudianteGuardado, "El estudiante guardado no debe ser nulo.");
        assertNotNull(estudianteGuardado.getId(), "El estudiante guardado debe tener un ID asignado.");
        // Aquí es donde el test debería fallar si los setters no estuvieran funcionando
        // o si el servicio hiciera algo inesperado con las propiedades.
        assertEquals("Ana", estudianteGuardado.getNombre(), "El nombre debe coincidir.");
        assertEquals("Lopez", estudianteGuardado.getApellido(), "El apellido debe coincidir.");
        assertEquals("ana.lopez@example.com", estudianteGuardado.getEmail(), "El email debe coincidir.");
        assertEquals(LocalDate.of(2000, 5, 15), estudianteGuardado.getFechaNacimiento(), "La fecha de nacimiento debe coincidir.");
    }
}
