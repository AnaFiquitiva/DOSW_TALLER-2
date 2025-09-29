package edu.dosw.taller.DOSW_TALLER_2.controller.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;


class CrearReporteDTOTest {

    @Test
    void testGettersSetters() {
        CrearReporteDTO dto = new CrearReporteDTO();

        dto.setTitulo("Reporte Test");
        dto.setAutor("Autor Test");
        dto.setContenido("Contenido Test");

        TransaccionDTO transaccion = new TransaccionDTO();
        transaccion.setId("1");
        transaccion.setDescripcion("Compra");
        transaccion.setMonto(new BigDecimal(100.0));
        transaccion.setCategoria("Gastos");

        List<TransaccionDTO> lista = new ArrayList<>();
        lista.add(transaccion);
        dto.setTransacciones(lista);

        dto.setConGraficas(true);
        dto.setConMarcaAgua(true);
        dto.setConResumen(true);
        dto.setExportable(true);

        assertEquals("Reporte Test", dto.getTitulo());
        assertEquals("Autor Test", dto.getAutor());
        assertEquals("Contenido Test", dto.getContenido());
        assertEquals(1, dto.getTransacciones().size());
        assertTrue(dto.isConGraficas());
        assertTrue(dto.isConMarcaAgua());
        assertTrue(dto.isConResumen());
        assertTrue(dto.isExportable());
    }
}
