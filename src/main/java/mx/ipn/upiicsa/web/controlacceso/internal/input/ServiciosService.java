package mx.ipn.upiicsa.web.controlacceso.internal.input;

import mx.ipn.upiicsa.web.controlacceso.external.mvc.dto.ServiciosDto;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Servicio;

import java.util.List;

public interface ServiciosService {
    List<Servicio> findAll();
    void save(ServiciosDto dto);
}
