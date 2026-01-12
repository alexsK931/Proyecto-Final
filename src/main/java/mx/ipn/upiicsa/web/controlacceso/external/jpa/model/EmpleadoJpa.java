package mx.ipn.upiicsa.web.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tce03_empleado")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class EmpleadoJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "fk_id_persona", referencedColumnName = "id_persona", unique = true)
    private PersonaJpa persona;

    @ManyToOne
    @JoinColumn(name = "fk_id_sucursal", referencedColumnName = "id_sucursal")
    private SucursalJpa sucursal;
}



