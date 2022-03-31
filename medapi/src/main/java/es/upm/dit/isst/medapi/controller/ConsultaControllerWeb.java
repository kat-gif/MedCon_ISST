package es.upm.dit.isst.medapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medcon")
public class ConsultaControllerWeb {

    @GetMapping(path= {"/medico"})
    public String inicio() {
        return "lista";        
    }
}