package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReporteBuilderTest {

    @Test
<<<<<<< HEAD
    void testBuildReporteBasico() {
        Transaccion t = new Transaccion("1", "Compra", BigDecimal.TEN, LocalDate.now(), "Alimentos");

        ReporteBasico reporte = new ReporteBuilder()
                .conTitulo("Titulo")
                .conFechaGeneracion(LocalDate.now())
                .conAutor("Autor")
                .conTransaccion(t)
                .conContenido("Contenido")
                .build();
=======
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

        ReporteBuilder builder = new ReporteBuilder();

        ReporteBuilder resultadoTitulo = builder.conTitulo("Reporte Prueba");
        ReporteBuilder resultadoFecha = builder.conFechaGeneracion(LocalDate.of(2025, 9, 28));
        ReporteBuilder resultadoAutor = builder.conAutor("AutorTest");
        ReporteBuilder resultadoContenido = builder.conContenido("Contenido de prueba");
        ReporteBuilder resultadoTransaccion = builder.conTransaccion(t);


        assertSame(builder, resultadoTitulo);
        assertSame(builder, resultadoFecha);
        assertSame(builder, resultadoAutor);
        assertSame(builder, resultadoContenido);
        assertSame(builder, resultadoTransaccion);


        ReporteBasico reporte = builder.build();
>>>>>>> 671e0fdc049d389e27d96a7b40bc33a689573778

        assertNotNull(reporte);
        assertEquals("Titulo", reporte.getTitulo());
        assertEquals("Autor", reporte.getAutor());
        assertEquals("Contenido", reporte.getContenido());
        assertEquals(1, reporte.getTransacciones().size());
    }

    @Test
<<<<<<< HEAD
    void testBuildSinContenido() {
=======
    void build_sinCamposObligatorios_lanzaExcepcion() {
        ReporteBuilder builder = new ReporteBuilder();

        IllegalStateException exception = assertThrows(IllegalStateException.class, builder::build);
        assertTrue(exception.getMessage().contains("Faltan campos obligatorios"));
    }

    @Test
    void conTransaccion_agregaVariasTransaccionesCorrectamente() {
        Transaccion t1 = new Transaccion("1", "Compra", new BigDecimal("50.00"), LocalDate.of(2025, 9, 28), "Gastos");
        Transaccion t2 = new Transaccion("2", "Venta", new BigDecimal("75.00"), LocalDate.of(2025, 9, 28), "Ingresos");

>>>>>>> 671e0fdc049d389e27d96a7b40bc33a689573778
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
