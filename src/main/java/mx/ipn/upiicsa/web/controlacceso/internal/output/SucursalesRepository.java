package mx.ipn.upiicsa.web.controlacceso.internal.output;

import mx.ipn.upiicsa.web.controlacceso.external.mvc.dto.SucursalDto;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Sucursal;
import java.util.List;

public interface SucursalesRepository {
    List<Sucursal> obtenerTodas();
    void guardar(SucursalDto dto); // Cambia Servicio/Sucursal por SucursalDto si es necesario
}
