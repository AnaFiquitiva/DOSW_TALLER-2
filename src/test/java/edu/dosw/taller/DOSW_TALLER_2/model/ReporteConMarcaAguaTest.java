package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReporteConMarcaAguaTest {

    @Test
    void generarReporte_agregaMarcaAgua() {

        Transaccion t = new Transaccion("1", "Compra", new BigDecimal("150.00"), LocalDate.of(2025, 9, 28), "Gastos");

        ReporteBasico base = new ReporteBuilder()
                .conTitulo("Reporte Confidencial")
                .conAutor("AutorTest")
                .conContenido("Contenido secreto")
                .conFechaGeneracion(LocalDate.of(2025, 9, 28))
                .conTransaccion(t)
                .build();


        Reporte reporteMarcaAgua = new ReporteConMarcaAgua(base);


        String resultado = reporteMarcaAgua.generarReporte();


        assertTrue(resultado.startsWith("*** CONFIDENCIAL - MARCA DE AGUA DE SEGURIDAD ***"));
        assertTrue(resultado.contains("Contenido secreto"));
        assertTrue(resultado.contains("AutorTest"));
        assertTrue(resultado.contains("=== REPORTE BÁSICO ==="));
    }
}


