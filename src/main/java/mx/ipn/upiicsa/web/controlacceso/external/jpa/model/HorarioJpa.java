package mx.ipn.upiicsa.web.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tce08_horario")
public class HorarioJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Integer id;

    @Column(name = "fk_id_sucursal")
    private Integer idSucursal;

    @Column(name = "fk_id_dia")
    private Integer idDia;

    @Column(name = "tm_inicio")
    private LocalTime horaInicio;

    @Column(name = "tm_fin")
    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "fk_id_sucursal", insertable = false, updatable = false)
    private SucursalJpa sucursal;
}
