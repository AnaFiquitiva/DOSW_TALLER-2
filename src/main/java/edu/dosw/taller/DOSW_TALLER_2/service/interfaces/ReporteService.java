package edu.dosw.taller.DOSW_TALLER_2.service.interfaces;
import edu.dosw.taller.DOSW_TALLER_2.model.ReporteDocument;
import edu.dosw.taller.DOSW_TALLER_2.model.Transaccion;

import java.time.LocalDate;
import java.util.List;

public interface ReporteService {

    /**
     * Crea un reporte financiero con las opciones de decoración especificadas.
     *
     * @param titulo              Título del reporte
     * @param autor               Autor del reporte
     * @param contenido           Contenido principal
     * @param transacciones       Lista de transacciones
     * @param conGraficas         ¿Agregar gráficas?
     * @param conMarcaAgua        ¿Agregar marca de agua de seguridad?
     * @param conResumen          ¿Agregar resumen estadístico?
     * @param exportable          ¿Hacer exportable a PDF/Excel?
     * @return ID del reporte guardado en MongoDB
     */
    String crearReporte(
            String titulo,
            String autor,
            String contenido,
            List<Transaccion> transacciones,
            boolean conGraficas,
            boolean conMarcaAgua,
            boolean conResumen,
            boolean exportable);

    /**
     * Obtiene todos los reportes almacenados.
     */
    List<ReporteDocument> obtenerTodos();

    /**
     * Filtra reportes por fecha de generación.
     */
    List<ReporteDocument> filtrarPorFecha(LocalDate fecha);

    /**
     * Filtra reportes por autor.
     */
    List<ReporteDocument> filtrarPorAutor(String autor);

    /**
     * Filtra reportes por tipo de contenido (búsqueda insensible a mayúsculas).
     */
    List<ReporteDocument> filtrarPorContenido(String tipo);
}
