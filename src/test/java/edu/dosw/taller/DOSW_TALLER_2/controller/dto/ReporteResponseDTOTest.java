package edu.dosw.taller.DOSW_TALLER_2.controller.dto;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReporteResponseDTOTest {

    @Test
    void testGettersSetters() {
        ReporteResponseDTO dto = new ReporteResponseDTO();

        dto.setId("R123");
        dto.setTitulo("Reporte Mensual");
        dto.setFechaGeneracion(LocalDate.of(2025, 9, 28));
        dto.setAutor("Ana");
        dto.setContenido("Contenido del reporte");
        dto.setContenidoFinal("Contenido final con decoraciones");
        dto.setTotalTransacciones(5);

        assertEquals("R123", dto.getId());
        assertEquals("Reporte Mensual", dto.getTitulo());
        assertEquals(LocalDate.of(2025, 9, 28), dto.getFechaGeneracion());
        assertEquals("Ana", dto.getAutor());
        assertEquals("Contenido del reporte", dto.getContenido());
        assertEquals("Contenido final con decoraciones", dto.getContenidoFinal());
        assertEquals(5, dto.getTotalTransacciones());
    }
}
