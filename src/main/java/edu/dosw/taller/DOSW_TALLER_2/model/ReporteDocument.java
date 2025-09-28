package edu.dosw.taller.DOSW_TALLER_2.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "reportes")
public class ReporteDocument {
    @Id
    private String id;
    private String titulo;
    private LocalDate fechaGeneracion;
    private String autor;
    private List<Transaccion> transacciones;
    private String contenido;
    private String contenidoFinal; // resultado tras aplicar decoradores
}
