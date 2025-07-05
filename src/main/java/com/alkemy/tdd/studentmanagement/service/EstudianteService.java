package com.alkemy.tdd.studentmanagement.service;

import com.alkemy.tdd.studentmanagement.model.Estudiante;

public class EstudianteService {

    private static Long nextId = 1L;

    public Estudiante crearEstudiante(Estudiante estudiante) {
        if (estudiante == null) {
            throw new IllegalArgumentException("El estudiante no puede ser nulo.");
        }
        if (estudiante.getNombre() == null || estudiante.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del estudiante es requerido.");
        }

        estudiante.setId(nextId);
        nextId++;

        return estudiante;
    }
}