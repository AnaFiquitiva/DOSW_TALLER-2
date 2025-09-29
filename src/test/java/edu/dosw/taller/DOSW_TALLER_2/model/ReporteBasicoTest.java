package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReporteBasicoTest {

    @Test
    void generarReporte_debeIncluirTodosLosCampos() {

        Transaccion t1 = new Transaccion("1", "Compra", new BigDecimal("100.50"), LocalDate.of(2025, 9, 28), "Gastos");
        Transaccion t2 = new Transaccion("2", "Venta", new BigDecimal("50.00"), LocalDate.of(2025, 9, 28), "Ingresos");
        ReporteBasico reporte = new ReporteBasico(
                "Reporte Prueba",
                LocalDate.of(2025, 9, 28),
                "AutorTest",
                List.of(t1, t2),
                "Contenido de prueba"
        );

        String resultado = reporte.generarReporte();

        assertTrue(resultado.contains("Reporte Prueba"));
        assertTrue(resultado.contains("AutorTest"));
        assertTrue(resultado.contains("Contenido de prueba"));
        assertTrue(resultado.contains("2 registros"));
    }

    @Test
    void getters_debenRetornarValoresCorrectos() {

        LocalDate fecha = LocalDate.of(2025, 9, 28);
        Transaccion transaccion = new Transaccion("1", "Compra", new BigDecimal("200.00"), fecha, "Gastos");
        List<Transaccion> transacciones = List.of(transaccion);
        ReporteBasico reporte = new ReporteBasico("Titulo", fecha, "Autor", transacciones, "Contenido");


        assertEquals("Titulo", reporte.getTitulo());
        assertEquals("Autor", reporte.getAutor());
        assertEquals(fecha, reporte.getFechaGeneracion());
        assertEquals(transacciones, reporte.getTransacciones());
        assertEquals("Contenido", reporte.getContenido());
    }
}
