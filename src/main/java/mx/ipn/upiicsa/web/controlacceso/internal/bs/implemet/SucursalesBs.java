package mx.ipn.upiicsa.web.controlacceso.internal.bs.implemet;


import mx.ipn.upiicsa.web.controlacceso.external.mvc.dto.SucursalDto;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Sucursal;
import mx.ipn.upiicsa.web.controlacceso.internal.input.SucursalesService;
import mx.ipn.upiicsa.web.controlacceso.internal.output.SucursalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SucursalesBs implements SucursalesService {

    @Autowired
    private SucursalesRepository sucursalesRepository; // Inyectamos la interfaz de salida

    @Override
    public List<Sucursal> findAll() {
        return sucursalesRepository.obtenerTodas();
    }

    @Override
    public void save(SucursalDto dto) {
        sucursalesRepository.guardar(dto);
    }
}
