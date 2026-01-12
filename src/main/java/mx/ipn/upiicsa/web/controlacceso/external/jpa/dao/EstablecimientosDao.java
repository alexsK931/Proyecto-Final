package mx.ipn.upiicsa.web.controlacceso.external.jpa.dao;

import mx.ipn.upiicsa.web.controlacceso.external.jpa.model.EstablecimientoJpa;
import mx.ipn.upiicsa.web.controlacceso.external.jpa.repository.EstablecimientosJpaRepository;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Establecimiento;
import mx.ipn.upiicsa.web.controlacceso.internal.output.EstablecimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("establecimientosDao")
public class EstablecimientosDao implements EstablecimientosRepository {

    @Autowired
    private EstablecimientosJpaRepository jpaRepository;

    @Override
    public List<Establecimiento> obtenerTodos() {
        return jpaRepository.findAll().stream().map(entidad -> {
            Establecimiento pojo = new Establecimiento();
            pojo.setId(entidad.getId());
            pojo.setNombre(entidad.getNombre());
            return pojo;
        }).collect(Collectors.toList());
    }

    @Override
    public void guardar(Establecimiento pojo) {
        EstablecimientoJpa entidad = new EstablecimientoJpa();
        entidad.setNombre(pojo.getNombre());
        jpaRepository.save(entidad);
    }
}
