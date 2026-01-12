package mx.ipn.upiicsa.web.controlacceso.internal.output;

import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Servicio;
import java.util.List;

public interface ServiciosRepository {
    List<Servicio> obtenerTodos();
    void save(Servicio servicio);

}
