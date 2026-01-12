package mx.ipn.upiicsa.web.controlacceso.internal.bs.entity;

import lombok.*;

@Builder
@Setter
@Getter
public class Cita {
    private Integer id;
    private Integer idPersona;
    private Integer idServicio;
    private Integer idListaPrecio;
    private Integer idSucursal;
    private Integer idEmpleado;
}
