package com.alkemy.tdd.studentmanagement.service;

import com.alkemy.tdd.studentmanagement.model.Estudiante;

public class EstudianteService {

    // Variable estática para simular un ID autoincremental, ya que aun no implemento bbdd.
    private static Long nextId = 1L;

    public Estudiante crearEstudiante(Estudiante estudiante) {
        // Primero, verifica si el estudiante o su nombre son nulos para un control básico
        if (estudiante == null) {
            throw new IllegalArgumentException("El estudiante no puede ser nulo.");
        }
        if (estudiante.getNombre() == null || estudiante.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del estudiante es requerido.");
        }

        estudiante.setId(nextId); // Asigna el ID actual
        nextId++; // Incrementa el ID para el próximo estudiante

        return estudiante;
    }
}