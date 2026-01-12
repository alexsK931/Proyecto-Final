package mx.ipn.upiicsa.web.controlacceso.internal.input;

import mx.ipn.upiicsa.web.controlacceso.external.mvc.dto.EstablecimientoDto;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Establecimiento;
import java.util.List;

public interface EstablecimientosService {
    List<Establecimiento> findAll();
    void save(EstablecimientoDto dto);
}
