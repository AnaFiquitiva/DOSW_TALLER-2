package edu.dosw.taller.DOSW_TALLER_2.controller.dto;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReporteDTOTest {

    @Test
    void testReporteDTOGettersSetters() {

        TransaccionDTO t1 = new TransaccionDTO();
        t1.setId("T1");
        t1.setDescripcion("Compra");
        t1.setMonto(new BigDecimal("150.500"));
        t1.setCategoria("Gastos");
        t1.setFecha(LocalDate.of(2025, 9, 28));

        TransaccionDTO t2 = new TransaccionDTO();
        t2.setId("T2");
        t2.setDescripcion("Venta");
        t2.setMonto(new BigDecimal("200.750"));
        t2.setCategoria("Ingresos");
        t2.setFecha(LocalDate.of(2025, 9, 27));


        ReporteDTO reporte = new ReporteDTO();
        reporte.setTitulo("Reporte Mensual");
        reporte.setAutor("Juan");
        reporte.setContenido("Resumen de transacciones");
        reporte.setFechaGeneracion(LocalDate.of(2025, 9, 28));
        reporte.setTransacciones(List.of(t1, t2));

        assertEquals("Reporte Mensual", reporte.getTitulo());
        assertEquals("Juan", reporte.getAutor());
        assertEquals("Resumen de transacciones", reporte.getContenido());
        assertEquals(LocalDate.of(2025, 9, 28), reporte.getFechaGeneracion());
        assertNotNull(reporte.getTransacciones());
        assertEquals(2, reporte.getTransacciones().size());


        assertEquals("T1", reporte.getTransacciones().get(0).getId());
        assertEquals("Compra", reporte.getTransacciones().get(0).getDescripcion());
        assertEquals(new BigDecimal("150.500"), reporte.getTransacciones().get(0).getMonto());

        assertEquals("T2", reporte.getTransacciones().get(1).getId());
        assertEquals("Venta", reporte.getTransacciones().get(1).getDescripcion());
        assertEquals(new BigDecimal("200.750"), reporte.getTransacciones().get(1).getMonto());
    }
}
