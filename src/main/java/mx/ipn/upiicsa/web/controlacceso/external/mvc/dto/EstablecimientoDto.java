package mx.ipn.upiicsa.web.controlacceso.external.mvc.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EstablecimientoDto {
    @NotBlank(message = "El nombre del establecimiento es obligatorio")
    private String nombre;
}
