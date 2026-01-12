package mx.ipn.upiicsa.web.controlacceso.external.jpa.repository;

import mx.ipn.upiicsa.web.controlacceso.external.jpa.model.EstablecimientoJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstablecimientosJpaRepository extends JpaRepository<EstablecimientoJpa, Integer> {
    Optional<EstablecimientoJpa> findByNombre(String nombre);
}
