package mx.ipn.upiicsa.web.controlacceso.internal.bs.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {
    private Integer id;
    private String nombre;
    private String nombreEstablecimiento; // Nombre de la marca asociada
}