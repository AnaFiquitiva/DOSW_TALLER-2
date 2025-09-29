package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReporteBuilderTest {

    @Test
    void testBuildReporteBasico() {
        Transaccion t = new Transaccion("1", "Compra", BigDecimal.TEN, LocalDate.now(), "Alimentos");

        ReporteBasico reporte = new ReporteBuilder()
                .conTitulo("Titulo")
                .conFechaGeneracion(LocalDate.now())
                .conAutor("Autor")
                .conTransaccion(t)
                .conContenido("Contenido")
                .build();

        assertNotNull(reporte);
        assertEquals("Titulo", reporte.getTitulo());
        assertEquals("Autor", reporte.getAutor());
        assertEquals("Contenido", reporte.getContenido());
        assertEquals(1, reporte.getTransacciones().size());
    }

    @Test
    void testBuildSinContenido() {
        ReporteBuilder builder = new ReporteBuilder()
                .conTitulo("Titulo")
                .conAutor("Autor")
                .conTransaccion(new Transaccion("1", "D", BigDecimal.ONE, LocalDate.now(), "C"));

        assertThrows(IllegalStateException.class, builder::build);
    }

    @Test
    void testBuildSinAutor() {
        ReporteBuilder builder = new ReporteBuilder()
                .conTitulo("Titulo")
                .conContenido("C")
                .conTransaccion(new Transaccion("1", "D", BigDecimal.ONE, LocalDate.now(), "C"));

        assertThrows(IllegalStateException.class, builder::build);
    }

    @Test
    void testBuildSinTitulo() {
        ReporteBuilder builder = new ReporteBuilder()
                .conAutor("Autor")
                .conContenido("C")
                .conTransaccion(new Transaccion("1", "D", BigDecimal.ONE, LocalDate.now(), "C"));

        assertThrows(IllegalStateException.class, builder::build);
    }

    @Test
    void testBuildConTransaccionesVacias() {
        ReporteBuilder builder = new ReporteBuilder()
                .conTitulo("Titulo")
                .conAutor("Autor")
                .conContenido("C");

        assertThrows(IllegalStateException.class, builder::build);
    }

}
