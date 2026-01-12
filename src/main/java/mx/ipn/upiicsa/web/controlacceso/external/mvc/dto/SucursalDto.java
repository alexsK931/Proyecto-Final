package mx.ipn.upiicsa.web.controlacceso.external.mvc.dto;

import lombok.Data;

@Data
public class SucursalDto {
    private String nombre; // Nombre de la sucursal
    private String nombreEstablecimiento; // Nombre que se buscará en la DB
}