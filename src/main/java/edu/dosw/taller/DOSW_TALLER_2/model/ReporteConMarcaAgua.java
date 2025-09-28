package edu.dosw.taller.DOSW_TALLER_2.model;


public class ReporteConMarcaAgua extends ReporteDecorator {
    public ReporteConMarcaAgua(Reporte reporte) {
        super(reporte);
    }

    @Override
    public String generarReporte() {
        return "*** CONFIDENCIAL - MARCA DE AGUA DE SEGURIDAD ***\n" +
                reporte.generarReporte();
    }
}
