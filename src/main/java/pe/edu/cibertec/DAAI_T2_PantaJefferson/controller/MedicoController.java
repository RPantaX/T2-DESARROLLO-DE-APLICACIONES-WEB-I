package pe.edu.cibertec.DAAI_T2_PantaJefferson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd.Medico;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.service.MedicoService;

@Controller
@RequestMapping("/Medico")
@RequiredArgsConstructor
public class MedicoController {
    public final MedicoService service;
    @GetMapping
    public String index(Model model) {
        model.addAttribute("medicos", service.getAllMedicos());
        return "medico/index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("medico", new Medico());
        return "medico/create";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("medico", service.getMedicoById(id));
        return "medico/edit";
    }

    @PostMapping("/save")
    public String save( @ModelAttribute("medico") Medico medico) {
        service.saveMedico(medico);
        return "redirect:/medico";
    }
}
