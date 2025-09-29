package edu.dosw.taller.DOSW_TALLER_2.controller.dto;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReporteResponseDTOTest {

    @Test
    void testGettersSettersYMetodosLombok() {
        ReporteResponseDTO dto1 = new ReporteResponseDTO();

        dto1.setId("R123");
        dto1.setTitulo("Reporte Mensual");
        dto1.setFechaGeneracion(LocalDate.of(2025, 9, 28));
        dto1.setAutor("Ana");
        dto1.setContenido("Contenido del reporte");
        dto1.setContenidoFinal("Contenido final con decoraciones");
        dto1.setTotalTransacciones(5);


        assertEquals("R123", dto1.getId());
        assertEquals("Reporte Mensual", dto1.getTitulo());
        assertEquals(LocalDate.of(2025, 9, 28), dto1.getFechaGeneracion());
        assertEquals("Ana", dto1.getAutor());
        assertEquals("Contenido del reporte", dto1.getContenido());
        assertEquals("Contenido final con decoraciones", dto1.getContenidoFinal());
        assertEquals(5, dto1.getTotalTransacciones());


        ReporteResponseDTO dto2 = new ReporteResponseDTO();
        dto2.setId("R123");
        dto2.setTitulo("Reporte Mensual");
        dto2.setFechaGeneracion(LocalDate.of(2025, 9, 28));
        dto2.setAutor("Ana");
        dto2.setContenido("Contenido del reporte");
        dto2.setContenidoFinal("Contenido final con decoraciones");
        dto2.setTotalTransacciones(5);

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());


        ReporteResponseDTO dto3 = new ReporteResponseDTO();
        dto3.setId("R999");
        assertNotEquals(dto1, dto3);


        String str = dto1.toString();
        assertNotNull(str);
        assertTrue(str.contains("R123"));
        assertTrue(str.contains("Reporte Mensual"));


        assertTrue(dto1.canEqual(dto2));
        assertFalse(dto1.canEqual("string"));
    }
}
