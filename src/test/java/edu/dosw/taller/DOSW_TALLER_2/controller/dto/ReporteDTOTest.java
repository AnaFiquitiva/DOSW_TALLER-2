package edu.dosw.taller.DOSW_TALLER_2.controller.dto;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;



class ReporteDTOTest {

    @Test
    void testGettersSettersYMetodosLombok() {

        TransaccionDTO t1 = new TransaccionDTO();
        t1.setId("T1");
        t1.setDescripcion("Compra");
        t1.setMonto(new java.math.BigDecimal("100.50"));
        t1.setFecha(LocalDate.of(2025, 9, 28));
        t1.setCategoria("Gastos");

        TransaccionDTO t2 = new TransaccionDTO();
        t2.setId("T2");
        t2.setDescripcion("Venta");
        t2.setMonto(new java.math.BigDecimal("200.75"));
        t2.setFecha(LocalDate.of(2025, 9, 27));
        t2.setCategoria("Ingresos");

        List<TransaccionDTO> lista = new ArrayList<>();
        lista.add(t1);
        lista.add(t2);

        ReporteDTO dto1 = new ReporteDTO();
        dto1.setTitulo("Reporte Mensual");
        dto1.setAutor("Ana");
        dto1.setContenido("Contenido del reporte");
        dto1.setFechaGeneracion(LocalDate.of(2025, 9, 28));
        dto1.setTransacciones(lista);


        assertEquals("Reporte Mensual", dto1.getTitulo());
        assertEquals("Ana", dto1.getAutor());
        assertEquals("Contenido del reporte", dto1.getContenido());
        assertEquals(LocalDate.of(2025, 9, 28), dto1.getFechaGeneracion());
        assertEquals(2, dto1.getTransacciones().size());


        ReporteDTO dto2 = new ReporteDTO();
        dto2.setTitulo("Reporte Mensual");
        dto2.setAutor("Ana");
        dto2.setContenido("Contenido del reporte");
        dto2.setFechaGeneracion(LocalDate.of(2025, 9, 28));
        dto2.setTransacciones(lista);

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());


        ReporteDTO dto3 = new ReporteDTO();
        dto3.setTitulo("Otro reporte");
        assertNotEquals(dto1, dto3);


        String str = dto1.toString();
        assertNotNull(str);
        assertTrue(str.contains("Reporte Mensual"));
        assertTrue(str.contains("Ana"));


        assertTrue(dto1.canEqual(dto2));
        assertFalse(dto1.canEqual("string"));
    }
}

