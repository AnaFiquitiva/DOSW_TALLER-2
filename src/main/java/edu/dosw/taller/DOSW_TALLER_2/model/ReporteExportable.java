package edu.dosw.taller.DOSW_TALLER_2.model;

public class ReporteExportable extends ReporteDecorator {
    public ReporteExportable(Reporte reporte) {
        super(reporte);
    }

    @Override
    public String generarReporte() {
        return reporte.generarReporte() + "\n[+] Exportable a PDF y Excel.";
    }
}