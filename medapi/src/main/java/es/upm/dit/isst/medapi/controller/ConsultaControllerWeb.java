package es.upm.dit.isst.medapi.controller;

import java.security.*;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

import es.upm.dit.isst.medapi.model.Consulta;

@Controller
@RequestMapping("/medcon")
public class ConsultaControllerWeb {

    public final String CONSULTAMANAGER_STRING= "http://localhost:8080/consultas/";
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/login")
    public String login() {
        return "login";        
    }

    @GetMapping("/juan")
    public String juan() {
        return "juanfran";        
    }

    @GetMapping("/agenda")
    public String lista (Model model, Principal principal) {
        List<Consulta> lista = new ArrayList<Consulta>();
        lista = Arrays.asList(restTemplate.getForEntity(CONSULTAMANAGER_STRING, Consulta[].class).getBody());
        model.addAttribute("consultas", lista);
        return "agenda";
    }

    
}