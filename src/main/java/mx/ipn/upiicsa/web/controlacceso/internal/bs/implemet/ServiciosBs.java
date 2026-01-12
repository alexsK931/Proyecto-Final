package mx.ipn.upiicsa.web.controlacceso.internal.bs.implemet;

import mx.ipn.upiicsa.web.controlacceso.external.jpa.dao.ServiciosDao;
import mx.ipn.upiicsa.web.controlacceso.external.mvc.dto.ServiciosDto;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Servicio;
import mx.ipn.upiicsa.web.controlacceso.internal.input.ServiciosService;
import mx.ipn.upiicsa.web.controlacceso.internal.output.ServiciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosBs implements ServiciosService {

    @Autowired
    private ServiciosRepository serviciosRepository;

    @Autowired
    private ServiciosDao servicioDao;

    @Override
    public List<Servicio> findAll() {
        return servicioDao.obtenerTodos();
    }

    @Override
    public void save(ServiciosDto dto) {
        Servicio entity = new Servicio();
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setDuracion(dto.getDuracion());
        entity.setActivo(1);

        servicioDao.save(entity);
    }
}
