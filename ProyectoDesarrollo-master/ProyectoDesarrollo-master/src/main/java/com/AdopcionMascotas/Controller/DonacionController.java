package com.AdopcionMascotas.Controller;

import com.AdopcionMascotas.Entity.Donacion;
import com.AdopcionMascotas.Service.IDonacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DonacionController {

    @Autowired
    private IDonacionService donacionService;

    @GetMapping("leerdonaciones")
    public String Index(Model model) {
        List<Donacion> listaDonacion = donacionService.getAllDonacion();
        model.addAttribute("titulo", "Lista de Donaciones");
        model.addAttribute("donacion", listaDonacion);
        return "leerdonaciones";
    }

    @GetMapping("donacionesN")
    public String CrearDonacion(Model model) {
        model.addAttribute("donacion", new Donacion());
        return "donaciones";
    }

    @PostMapping("/saveD")
    public String GuardarDonacion(@ModelAttribute Donacion D) {
        donacionService.saveDonacion(D);
        return "redirect:/index.html";
    }

    
}
