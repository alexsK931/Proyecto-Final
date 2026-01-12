package mx.ipn.upiicsa.web.controlacceso.internal.output;

import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Establecimiento;
import java.util.List;

public interface EstablecimientosRepository {
    List<Establecimiento> obtenerTodos();
    void guardar(Establecimiento establecimiento);
}
