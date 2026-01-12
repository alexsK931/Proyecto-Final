package mx.ipn.upiicsa.web.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "cci01_servicio")
public class ServicioJpa {
    @Id
    @Column(name = "id_servicio")
    private Integer id;
    @Column(name = "tx_nombre")
    private String nombre;
    @Column(name = "tx_descripcion")
    private String descripcion;
    @Column(name = "st_activo")
    private Integer activo;
    @Column(name = "nu_duracion")
    private Integer duracion;
    @OneToMany(mappedBy = "servicio")
    private List<ServicioListaPrecioJpa> servicioslistasPrecios;
}
