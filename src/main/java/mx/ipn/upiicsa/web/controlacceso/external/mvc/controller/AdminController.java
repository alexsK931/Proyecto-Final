package mx.ipn.upiicsa.web.controlacceso.external.mvc.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import mx.ipn.upiicsa.web.controlacceso.external.jpa.repository.EstablecimientosJpaRepository;
import mx.ipn.upiicsa.web.controlacceso.external.jpa.repository.ServiciosJpaRepository;
import mx.ipn.upiicsa.web.controlacceso.external.jpa.repository.SucursalesJpaRepository;
import mx.ipn.upiicsa.web.controlacceso.external.mvc.dto.EstablecimientoDto;
import mx.ipn.upiicsa.web.controlacceso.external.mvc.dto.ServiciosDto;
import mx.ipn.upiicsa.web.controlacceso.external.mvc.dto.SucursalDto;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.implemet.EstablecimientosBs;
import mx.ipn.upiicsa.web.controlacceso.internal.bs.implemet.ServiciosBs;
import mx.ipn.upiicsa.web.controlacceso.internal.input.EstablecimientosService;
import mx.ipn.upiicsa.web.controlacceso.internal.input.SucursalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ServiciosBs servicioBs;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        Object persona = session.getAttribute("persona");

        if (persona == null) {return "redirect:/";}

        model.addAttribute("persona", persona);

        return "admin-home";
    }

    @GetMapping("/servicios")
    public String mostrarServicios(Model model) {
        // Asegúrate de usar "nuevoServicio" y la clase ServiciosDto
        model.addAttribute("nuevoServicio", new ServiciosDto());
        model.addAttribute("servicios", servicioBs.findAll());
        return "admin_servicios";
    }

    @PostMapping("/servicios/guardar")
    public String guardar(@Valid @ModelAttribute("nuevoServicio") ServiciosDto dto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("nuevoServicio", new ServiciosDto());
            return "admin_servicios";
        }
        servicioBs.save(dto);
        return "redirect:/admin/servicios";
    }

    @Autowired
    private EstablecimientosBs establecimientoBs;

    @GetMapping("/establecimientos")
    public String mostrarEstablecimientos(Model model) {
        model.addAttribute("nuevoEstablecimiento", new EstablecimientoDto());
        model.addAttribute("establecimientos", establecimientoBs.findAll());
        return "admin_establecimientos";
    }

    @PostMapping("/establecimientos/guardar")
    public String guardarEstablecimiento(@Valid @ModelAttribute("nuevoEstablecimiento") EstablecimientoDto dto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("establecimientos", establecimientoBs.findAll());
            return "admin_establecimientos";
        }
        establecimientoBs.save(dto);
        return "redirect:/admin/establecimientos";
    }

    @Autowired
    private EstablecimientosService establecimientoService;

    // 1. Inyectamos el nuevo servicio de sucursales
    @Autowired
    private SucursalesService sucursalService;

    // ... (métodos de dashboard, servicios y establecimientos)

    /**
     * Muestra la pantalla de gestión de sucursales
     */
    @GetMapping("/sucursales")
    public String mostrarSucursales(Model model) {
        // Enviamos un DTO vacío para el formulario de registro
        model.addAttribute("nuevaSucursal", new SucursalDto());

        // Enviamos la lista de sucursales registradas (que ya incluye el nombre del establecimiento)
        model.addAttribute("sucursales", sucursalService.findAll());

        return "admin_sucursales";
    }

    /**
     * Procesa el guardado de una nueva sucursal
     */
    @PostMapping("/sucursales/guardar")
    public String guardarSucursal(@Valid @ModelAttribute("nuevaSucursal") SucursalDto dto,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            // Si hay errores de validación, recargamos la lista y volvemos a la vista
            model.addAttribute("sucursales", sucursalService.findAll());
            return "admin_sucursales";
        }

        try {
            // El BS llamará al DAO, el cual buscará el establecimiento por nombre
            sucursalService.save(dto);
        } catch (RuntimeException e) {
            // Si el establecimiento no existe, capturamos el error del DAO
            // y lo mandamos de vuelta a la vista para mostrarlo en el alert
            model.addAttribute("error", e.getMessage());
            model.addAttribute("sucursales", sucursalService.findAll());
            return "admin_sucursales";
        }

        return "redirect:/admin/sucursales";
    }

    @Autowired
    private EstablecimientosJpaRepository establecimientoRepo; //

    @Autowired
    private SucursalesJpaRepository sucursalRepo; //

    @Autowired
    private ServiciosJpaRepository servicioRepo; //

    @GetMapping("/admin/home")
    public String home(Model model, HttpSession session) {
        var persona = session.getAttribute("persona");
        if (persona == null) return "redirect:/";

        model.addAttribute("totalEstablecimientos", establecimientoRepo.count());
        model.addAttribute("totalSucursales", sucursalRepo.count());
        model.addAttribute("totalServicios", servicioRepo.count());

        model.addAttribute("persona", persona);

        return "admin-home";
    }
}
