package mx.ipn.upiicsa.web.controlacceso.external.jpa.repository;

import mx.ipn.upiicsa.web.controlacceso.external.jpa.model.ServicioJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiciosJpaRepository extends JpaRepository<ServicioJpa, Integer> {
    @Query("SELECT MAX(s.id) FROM ServicioJpa s")
    Integer findMaxId();
}