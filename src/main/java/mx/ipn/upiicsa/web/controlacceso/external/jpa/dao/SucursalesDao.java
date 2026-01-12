package mx.ipn.upiicsa.web.controlacceso.external.jpa.dao;

import mx.ipn.upiicsa.web.controlacceso.external.jpa.model.EstablecimientoJpa;
import mx.ipn.upiicsa.web.controlacceso.external.jpa.model.SucursalJpa;
import mx.ipn.upiicsa.web.controlacceso.external.jpa.repository.SucursalesJpaRepository;
import mx.ipn.upiicsa.web.controlacceso.external.mvc.dto.SucursalDto;
import mx.ipn.upiicsa.web.controlacceso.internal.output.SucursalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.ipn.upiicsa.web.controlacceso.external.jpa.repository.EstablecimientosJpaRepository;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Sucursal;

import java.util.List;
import java.util.stream.Collectors;

@Service("sucursalesDao")
public class SucursalesDao implements SucursalesRepository {

    @Autowired
    private SucursalesJpaRepository sucursalesJpaRepository;

    @Autowired
    private EstablecimientosJpaRepository establecimientosJpaRepository;

    @Override
    public List<Sucursal> obtenerTodas() {
        // Obtenemos todas las entidades JPA
        List<SucursalJpa> entidades = sucursalesJpaRepository.findAll();

        // Convertimos a POJOs de negocio para la vista
        return entidades.stream().map(entidad -> {
            Sucursal pojo = new Sucursal();
            pojo.setId(entidad.getId());
            pojo.setNombre(entidad.getNombre());
            // Extraemos el nombre del establecimiento desde la relación JPA
            if (entidad.getEstablecimiento() != null) {
                pojo.setNombreEstablecimiento(entidad.getEstablecimiento().getNombre());
            }
            return pojo;
        }).collect(Collectors.toList());
    }

    @Override
    public void guardar(SucursalDto dto) {

        EstablecimientoJpa marca = establecimientosJpaRepository.findByNombre(dto.getNombreEstablecimiento())
                .orElseThrow(() -> new RuntimeException("No se encontró el establecimiento: " + dto.getNombreEstablecimiento()));

        SucursalJpa entidad = new SucursalJpa();
        entidad.setNombre(dto.getNombre());

        entidad.setEstablecimiento(marca);

        sucursalesJpaRepository.save(entidad);
    }
}
