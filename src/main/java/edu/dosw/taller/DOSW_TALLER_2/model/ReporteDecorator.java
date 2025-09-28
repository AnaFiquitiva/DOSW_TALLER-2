package edu.dosw.taller.DOSW_TALLER_2.model;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public abstract class ReporteDecorator implements Reporte {
    protected final Reporte reporte;

    @Override
    public String getTitulo() { return reporte.getTitulo(); }
    @Override
    public java.time.LocalDate getFechaGeneracion() { return reporte.getFechaGeneracion(); }
    @Override
    public String getAutor() { return reporte.getAutor(); }
    @Override
    public java.util.List<Transaccion> getTransacciones() {
        return reporte.getTransacciones();
    }
    @Override
    public String getContenido() { return reporte.getContenido(); }
}
