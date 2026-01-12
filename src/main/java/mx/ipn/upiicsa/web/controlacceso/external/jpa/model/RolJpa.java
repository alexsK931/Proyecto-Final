package mx.ipn.upiicsa.web.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Rol;

import java.util.List;

@Entity
@Table(name = "cca02_rol")
public class RolJpa {
    @Id
    @Column(name = "id_rol")
    private Integer id;
    @Column(name = "tx_nombre")
    private String nombre;
    @Column(name = "tx_descripcion")
    private String descripcion;
    @Column(name = "st_activo")
    private Boolean activo;
    @OneToMany(mappedBy = "rol")
    public List<UsuarioJpa> usuarios;

    public Rol toEntity() {
        return Rol.builder()
                .id(this.id)
                .nombre(this.nombre)
                .descripcion(this.descripcion)
                .activo(this.activo)
                .build();
    }
}
