package edu.dosw.taller.DOSW_TALLER_2.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ReporteConResumen extends ReporteDecorator {
    public ReporteConResumen(Reporte reporte) {
        super(reporte);
    }

    @Override
    public String generarReporte() {
        List<Transaccion> trans = reporte.getTransacciones();
        BigDecimal total = trans.stream()
                .map(Transaccion::getMonto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        double promedio = trans.isEmpty() ? 0 : total.divide(BigDecimal.valueOf(trans.size()), 2, RoundingMode.HALF_UP).doubleValue();

        return reporte.generarReporte() + "\n[+] Resumen estadístico:\n" +
                "   • Total: $" + total + "\n" +
                "   • Promedio: $" + promedio + "\n" +
                "   • Número de transacciones: " + trans.size();
    }
}