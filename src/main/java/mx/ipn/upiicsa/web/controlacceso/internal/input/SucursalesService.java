package mx.ipn.upiicsa.web.controlacceso.internal.input;

import mx.ipn.upiicsa.web.controlacceso.external.mvc.dto.SucursalDto;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Sucursal;
import java.util.List;

public interface SucursalesService {
    List<Sucursal> findAll();
    void save(SucursalDto dto); // Debe recibir el DTO
}