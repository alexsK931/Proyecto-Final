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
@Table(name = "tce01_establecimiento")
public class EstablecimientoJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_establecimiento")
    private Integer id;

    @Column(name = "tx_nombre")
    private String nombre;

    @OneToMany(mappedBy = "establecimiento")
    private List<SucursalJpa> sucursales;
}
