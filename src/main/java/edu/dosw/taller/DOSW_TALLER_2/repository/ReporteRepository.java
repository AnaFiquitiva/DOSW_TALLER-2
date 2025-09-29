package edu.dosw.taller.DOSW_TALLER_2.repository;
import edu.dosw.taller.DOSW_TALLER_2.model.ReporteDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReporteRepository extends MongoRepository<ReporteDocument, String> {

    /**
     * Método personalizado (opcional): filtrar por fecha.
     * Spring Data lo implementa automáticamente gracias al nombre del método.
     */
    List<ReporteDocument> findByFechaGeneracion(LocalDate fecha);

    /**
     * Método personalizado: filtrar por autor (búsqueda exacta, insensible a mayúsculas se hará en el servicio con Streams).
     */
    List<ReporteDocument> findByAutor(String autor);

}