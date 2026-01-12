package mx.ipn.upiicsa.web.controlacceso.internal.bs.implemet;

import mx.ipn.upiicsa.web.controlacceso.external.mvc.dto.EstablecimientoDto;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Establecimiento;
import mx.ipn.upiicsa.web.controlacceso.internal.input.EstablecimientosService;
import mx.ipn.upiicsa.web.controlacceso.internal.output.EstablecimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablecimientosBs implements EstablecimientosService {

    @Autowired
    private EstablecimientosRepository establecimientosRepository;

    @Override
    public List<Establecimiento> findAll() {
        return establecimientosRepository.obtenerTodos();
    }

    @Override
    public void save(EstablecimientoDto dto) {
        Establecimiento entity = new Establecimiento();
        entity.setNombre(dto.getNombre());
        establecimientosRepository.guardar(entity);
    }
}
