package mx.ipn.upiicsa.web.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tci02_servicio_lista_precio")
@IdClass(ServicioListaPrecioId.class)
@Data
public class ServicioListaPrecioJpa {

    @Id
    @Column(name = "fk_id_servicio")
    private Integer fkIdServicio;
    @Id
    @Column(name = "fk_id_lista_precio")
    private Integer fkIdListaPrecio;
    @Column(name = "nu_precio")
    private Integer nuPrecio;
    @ManyToOne
    @JoinColumn (name = "fk_id_servicio", referencedColumnName = "id_servicio", insertable = false, updatable = false)
    private ServicioJpa servicio;
    @ManyToOne
    @JoinColumn(name = "fk_id_lista_precio", referencedColumnName = "id_lista_precio", insertable = false, updatable = false)
    private ListaPrecioJpa listaPrecio;
    @OneToMany(mappedBy = "servicioListaPrecio")
    List<CitaJpa> citas;
}
