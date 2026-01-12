package mx.ipn.upiicsa.web.controlacceso.external.jpa.dao;

import mx.ipn.upiicsa.web.controlacceso.external.jpa.model.ServicioJpa;
import mx.ipn.upiicsa.web.controlacceso.external.jpa.repository.ServiciosJpaRepository;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Servicio;
import mx.ipn.upiicsa.web.controlacceso.internal.output.ServiciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviciosDao")
public class ServiciosDao implements ServiciosRepository {

    @Autowired
    private ServiciosJpaRepository jpaRepository;

    @Override
    public List<Servicio> obtenerTodos() {
        List<ServicioJpa> entidades = jpaRepository.findAll();

        return entidades.stream().map(entidad -> {
            Servicio pojo = new Servicio();
            pojo.setId(entidad.getId());
            pojo.setNombre(entidad.getNombre());
            pojo.setDescripcion(entidad.getDescripcion());
            pojo.setDuracion(entidad.getDuracion());
            pojo.setActivo(entidad.getActivo());
            return pojo;
        }).collect(Collectors.toList());
    }

    @Override
    public void save(Servicio pojo) {

        Integer maxId = jpaRepository.findMaxId();

        Integer nuevoId = (maxId == null) ? 1 : maxId + 1;

        ServicioJpa entidad = new ServicioJpa();

        entidad.setId(nuevoId);

        entidad.setNombre(pojo.getNombre());
        entidad.setDescripcion(pojo.getDescripcion());
        entidad.setDuracion(pojo.getDuracion());
        entidad.setActivo(pojo.getActivo());

        jpaRepository.save(entidad);
    }
}