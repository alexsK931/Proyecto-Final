package mx.ipn.upiicsa.web.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tce02_sucursal") // Tu tabla real
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class SucursalJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Integer id;

    @Column(name = "tx_nombre")
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER) // Cambiamos a EAGER para asegurar que el objeto esté presente
    @JoinColumn(name = "fk_id_establecimiento", nullable = false) // Debe coincidir con el error
    private EstablecimientoJpa establecimiento;
}
