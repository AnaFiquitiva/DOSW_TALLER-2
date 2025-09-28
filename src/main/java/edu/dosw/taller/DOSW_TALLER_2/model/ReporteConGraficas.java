package edu.dosw.taller.DOSW_TALLER_2.model;

public class ReporteConGraficas extends ReporteDecorator {
    public ReporteConGraficas(Reporte reporte) {
        super(reporte);
    }

    @Override
    public String generarReporte() {
        return reporte.generarReporte() + "\n[+] Incluye gráficas de análisis financiero.";
    }
}
