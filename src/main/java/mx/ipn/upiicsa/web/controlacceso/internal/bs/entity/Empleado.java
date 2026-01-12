package mx.ipn.upiicsa.web.controlacceso.internal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Persona;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Sucursal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    private Integer id;
    private Persona persona;
    private Sucursal sucursal;
}
