package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReporteConResumenTest {

    private Reporte reporteBase;

    @BeforeEach
    void setUp() {

        reporteBase = new Reporte() {
            private List<Transaccion> transacciones;

            @Override
            public String generarReporte() {
                return "Reporte base";
            }

            @Override
            public List<Transaccion> getTransacciones() {
                return transacciones;
            }


            public void setTransacciones(List<Transaccion> trans) {
                this.transacciones = trans;
            }
        };
    }

    @Test
    void testGenerarReporteConTransacciones() {

        Transaccion t1 = new Transaccion("Compra 1", BigDecimal.valueOf(100));
        Transaccion t2 = new Transaccion("Compra 2", BigDecimal.valueOf(200));
        ((Reporte) reporteBase).getClass()
                .cast(reporteBase)
                .setTransacciones(Arrays.asList(t1, t2));

        ReporteConResumen reporte = new ReporteConResumen(reporteBase);


        String resultado = reporte.generarReporte();


        assertTrue(resultado.contains("Reporte base"));
        assertTrue(resultado.contains("Total: $300"));
        assertTrue(resultado.contains("Promedio: $150.0"));
        assertTrue(resultado.contains("Número de transacciones: 2"));
    }

    @Test
    void testGenerarReporteSinTransacciones() {

        ((Reporte) reporteBase).getClass()
                .cast(reporteBase)
                .setTransacciones(Collections.emptyList());

        ReporteConResumen reporte = new ReporteConResumen(reporteBase);


        String resultado = reporte.generarReporte();


        assertTrue(resultado.contains("Reporte base"));
        assertTrue(resultado.contains("Total: $0"));
        assertTrue(resultado.contains("Promedio: $0.0"));
        assertTrue(resultado.contains("Número de transacciones: 0"));
    }
}
