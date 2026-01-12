package mx.ipn.upiicsa.web.controlacceso.external.mvc.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ServiciosDto {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    private String descripcion;

    @NotNull(message = "La duración es obligatoria")
    @Min(value = 5, message = "Mínimo 5 minutos")
    private Integer duracion;
}
