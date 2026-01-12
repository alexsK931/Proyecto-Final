package mx.ipn.upiicsa.web.controlacceso.external.jpa.model;

import java.io.Serializable;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ServicioListaPrecioId implements Serializable {
    private Integer fkIdServicio;
    private Integer fkIdListaPrecio;
}
