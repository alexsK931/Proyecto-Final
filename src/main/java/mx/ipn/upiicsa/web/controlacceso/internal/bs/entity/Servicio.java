package mx.ipn.upiicsa.web.controlacceso.internal.bs.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Integer duracion;
    private Integer activo;
}
