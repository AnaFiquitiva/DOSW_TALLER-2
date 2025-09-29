package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReporteConGraficasTest {

    @Test
    void generarReporte_decoradorAgregaGraficas() {

        Transaccion t = new Transaccion("1", "Compra", new BigDecimal("100.00"), LocalDate.of(2025, 9, 28), "Gastos");

        ReporteBasico base = new ReporteBuilder()
                .conTitulo("Reporte Test")
                .conAutor("AutorTest")
                .conContenido("Contenido de prueba")
                .conFechaGeneracion(LocalDate.of(2025, 9, 28))
                .conTransaccion(t)
                .build();


        Reporte reporteConGraficas = new ReporteConGraficas(base);


        String resultado = reporteConGraficas.generarReporte();

        assertTrue(resultado.contains("=== REPORTE BÁSICO ==="));
        assertTrue(resultado.contains("Incluye gráficas de análisis financiero"));
        assertTrue(resultado.contains("Contenido de prueba"));
        assertTrue(resultado.contains("AutorTest"));
    }
}
