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
@Table(name = "tci01_estado_lista_precio")
public class EstadoListaPrecioJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Integer id;

    @Column(name = "tx_nombre")
    private String nombre;

    @OneToMany(mappedBy = "estado")
    private List<ListaPrecioJpa> listasPrecios;
}
