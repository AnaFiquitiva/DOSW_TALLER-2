package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransaccionTest {

    @Test
    void testConstructorConParametrosYGetters() {
        LocalDate fecha = LocalDate.of(2025, 9, 28);

        Transaccion transaccion = new Transaccion(
                "T001",
                "Compra de libros",
                BigDecimal.valueOf(150.75),
                fecha,
                "Educación"
        );

        assertEquals("T001", transaccion.getId());
        assertEquals("Compra de libros", transaccion.getDescripcion());
        assertEquals(BigDecimal.valueOf(150.75), transaccion.getMonto());
        assertEquals(fecha, transaccion.getFecha());
        assertEquals("Educación", transaccion.getCategoria());
    }

    @Test
    void testConstructorVacioYSetters() {
        Transaccion transaccion = new Transaccion();
        LocalDate fecha = LocalDate.of(2025, 1, 1);

        transaccion.setId("T002");
        transaccion.setDescripcion("Pago de servicios");
        transaccion.setMonto(BigDecimal.valueOf(80.50));
        transaccion.setFecha(fecha);
        transaccion.setCategoria("Servicios");

        assertEquals("T002", transaccion.getId());
        assertEquals("Pago de servicios", transaccion.getDescripcion());
        assertEquals(BigDecimal.valueOf(80.50), transaccion.getMonto());
        assertEquals(fecha, transaccion.getFecha());
        assertEquals("Servicios", transaccion.getCategoria());
    }

    @Test
    void testEqualsYHashCode() {
        LocalDate fecha = LocalDate.of(2025, 9, 28);

        Transaccion t1 = new Transaccion("T003", "Compra", BigDecimal.TEN, fecha, "General");
        Transaccion t2 = new Transaccion("T003", "Compra", BigDecimal.TEN, fecha, "General");

        assertEquals(t1, t2);
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void testToStringContieneCampos() {
        LocalDate fecha = LocalDate.of(2025, 9, 28);
        Transaccion transaccion = new Transaccion("T004", "Venta", BigDecimal.ONE, fecha, "Ingresos");

        String toString = transaccion.toString();

        assertTrue(toString.contains("T004"));
        assertTrue(toString.contains("Venta"));
        assertTrue(toString.contains("Ingresos"));
    }
}

