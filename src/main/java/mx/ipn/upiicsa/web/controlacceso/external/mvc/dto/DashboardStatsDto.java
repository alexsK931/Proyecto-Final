package mx.ipn.upiicsa.web.controlacceso.external.mvc.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardStatsDto {
    private long totalEstablecimientos;
    private long totalSucursales;
    private long totalServicios;
}
