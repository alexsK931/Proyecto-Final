package mx.ipn.upiicsa.web.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tci03_lista_precio")
public class ListaPrecioJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_precio")
    private Integer id;

    @Column(name = "fk_id_estado")
    private Integer idEstado;

    @Column(name = "tx_nombre")
    private String nombre;

    @Column(name = "fh_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fh_fin")
    private LocalDateTime fechaFin;

    @ManyToOne
    @JoinColumn(name = "fk_id_estado", referencedColumnName = "id_estado", insertable = false, updatable = false)
    private EstadoListaPrecioJpa estado;

    @OneToMany(mappedBy = "listaPrecio")
    private List<ServicioListaPrecioJpa> serviciosPrecios;
}
