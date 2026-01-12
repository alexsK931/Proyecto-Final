package mx.ipn.upiicsa.web.controlacceso.internal.bs.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Rol {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Boolean activo;
}
