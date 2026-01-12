package mx.ipn.upiicsa.web.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.entity.Cita;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tci05_cita")
public class CitaJpa {
    @Id
    @SequenceGenerator(name = "tci05_cita_id_cita_seq", sequenceName = "tci05_cita_id_cita_seq", allocationSize = 1)
    @GeneratedValue(generator = "tci05_cita_id_cita_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cita")
    private Integer id;
    @Column(name = "fk_id_persona")
    private Integer idPersona;
    @Column(name = "fk_id_servicio")
    private Integer idServicio;
    @Column(name = "fk_id_lista_precio")
    private Integer idListaPrecio;
    @Column(name = "fk_id_sucursal")
    private Integer idSucursal;
    @Column(name = "fk_id_empleado")
    private Integer idEmpleado;
    @ManyToOne
    @JoinColumn(name = "fk_id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    private PersonaJpa persona;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "fk_id_servicio", referencedColumnName = "fk_id_servicio", insertable = false, updatable = false),
            @JoinColumn(name = "fk_id_lista_precio", referencedColumnName = "fk_id_lista_precio", insertable = false, updatable = false)
    })
    private ServicioListaPrecioJpa servicioListaPrecio;
    @ManyToOne
    @JoinColumn(name = "fk_id_sucursal", referencedColumnName = "id_sucursal", insertable = false, updatable = false)
    private SucursalJpa sucursal;
    @ManyToOne
    @JoinColumn(name = "fk_id_empleado", referencedColumnName = "id_empleado", insertable = false, updatable = false)
    private EmpleadoJpa empleado;

    public static CitaJpa fromEntity(Cita cita) {
        return CitaJpa.builder()
                .id(cita.getId())
                .idPersona(cita.getIdPersona())
                .idServicio(cita.getIdServicio())
                .idListaPrecio(cita.getIdListaPrecio())
                .idSucursal(cita.getIdSucursal())
                .idEmpleado(cita.getIdEmpleado())
                .build();
    }

    public Cita toEntity() {
        return Cita.builder()
                .id(id)
                .idPersona(idPersona)
                .idServicio(idServicio)
                .idListaPrecio(idListaPrecio)
                .idSucursal(idSucursal)
                .idEmpleado(idEmpleado)
                .build();
    }
}


