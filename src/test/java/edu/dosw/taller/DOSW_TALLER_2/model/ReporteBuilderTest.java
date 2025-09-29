package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReporteBuilderTest {

    @Test
    void reporteBasico_gettersFuncionanCorrectamente() {
        Transaccion t = new Transaccion("1", "Compra", BigDecimal.TEN, LocalDate.of(2025, 9, 28), "Gastos");
        ReporteBasico reporte = new ReporteBasico("Titulo", LocalDate.of(2025, 9, 28), "Autor", List.of(t), "Contenido");

        assertEquals("Titulo", reporte.getTitulo());
        assertEquals(LocalDate.of(2025, 9, 28), reporte.getFechaGeneracion());
        assertEquals("Autor", reporte.getAutor());
        assertEquals("Contenido", reporte.getContenido());
        assertEquals(1, reporte.getTransacciones().size());
    }

    @Test
    void build_deberiaCrearReporteBasicoCorrectamente() {
        Transaccion t = new Transaccion("1", "Compra", new BigDecimal("100.50"), LocalDate.of(2025, 9, 28), "Gastos");

        ReporteBuilder builder = new ReporteBuilder()
                .conTitulo("Reporte Prueba")
                .conFechaGeneracion(LocalDate.of(2025, 9, 28))
                .conAutor("AutorTest")
                .conContenido("Contenido de prueba")
                .conTransaccion(t);

        ReporteBasico reporte = builder.build();

        assertNotNull(reporte);
        assertEquals("Reporte Prueba", reporte.getTitulo());
        assertEquals("AutorTest", reporte.getAutor());
        assertEquals("Contenido de prueba", reporte.getContenido());
        assertEquals(1, reporte.getTransacciones().size());
        assertEquals(t, reporte.getTransacciones().get(0));
    }

    @Test
    void build_sinCamposObligatorios_lanzaExcepcion() {
        ReporteBuilder builder = new ReporteBuilder();
        IllegalStateException exception = assertThrows(IllegalStateException.class, builder::build);
        assertTrue(exception.getMessage().contains("Faltan campos obligatorios"));
    }

    @Test
    void conTransaccion_agregaVariasTransaccionesCorrectamente() {
        Transaccion t1 = new Transaccion("1", "Compra", new BigDecimal("50.00"), LocalDate.of(2025, 9, 28), "Gastos");
        Transaccion t2 = new Transaccion("2", "Venta", new BigDecimal("75.00"), LocalDate.of(2025, 9, 28), "Ingresos");

        ReporteBuilder builder = new ReporteBuilder()
                .conTitulo("Reporte")
                .conAutor("Autor")
                .conContenido("Contenido")
                .conFechaGeneracion(LocalDate.now())
                .conTransaccion(t1)
                .conTransaccion(t2);

        ReporteBasico reporte = builder.build();

        assertEquals(2, reporte.getTransacciones().size());
        assertTrue(reporte.getTransacciones().containsAll(List.of(t1, t2)));
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
