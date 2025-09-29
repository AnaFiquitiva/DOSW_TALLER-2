package edu.dosw.taller.DOSW_TALLER_2.controller.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;


class CrearReporteDTOTest {

    @Test
    void testGettersSettersYMetodosLombok() {
        // Crear transacciones
        TransaccionDTO t1 = new TransaccionDTO();
        t1.setId("T1");
        t1.setDescripcion("Compra");
        t1.setMonto(new BigDecimal("100.50"));
        t1.setCategoria("Gastos");

        TransaccionDTO t2 = new TransaccionDTO();
        t2.setId("T2");
        t2.setDescripcion("Venta");
        t2.setMonto(new BigDecimal("200.75"));
        t2.setCategoria("Ingresos");

        List<TransaccionDTO> lista = new ArrayList<>();
        lista.add(t1);
        lista.add(t2);

        // Crear DTO
        CrearReporteDTO dto = new CrearReporteDTO();
        dto.setTitulo("Reporte Mensual");
        dto.setAutor("Ana");
        dto.setContenido("Contenido del reporte");
        dto.setTransacciones(lista);

        dto.setConGraficas(true);
        dto.setConMarcaAgua(true);
        dto.setConResumen(true);
        dto.setExportable(true);

        // Verificar getters
        assertEquals("Reporte Mensual", dto.getTitulo());
        assertEquals("Ana", dto.getAutor());
        assertEquals("Contenido del reporte", dto.getContenido());
        assertEquals(2, dto.getTransacciones().size());

        // Verificar booleanos
        assertTrue(dto.isConGraficas());
        assertTrue(dto.isConMarcaAgua());
        assertTrue(dto.isConResumen());
        assertTrue(dto.isExportable());

        // equals y hashCode
        CrearReporteDTO dto2 = new CrearReporteDTO();
        dto2.setTitulo("Reporte Mensual");
        dto2.setAutor("Ana");
        dto2.setContenido("Contenido del reporte");
        dto2.setTransacciones(lista);
        dto2.setConGraficas(true);
        dto2.setConMarcaAgua(true);
        dto2.setConResumen(true);
        dto2.setExportable(true);

        assertEquals(dto, dto2);
        assertEquals(dto.hashCode(), dto2.hashCode());

        // toString
        String str = dto.toString();
        assertNotNull(str);
        assertTrue(str.contains("Reporte Mensual"));
        assertTrue(str.contains("Ana"));
    }
}

