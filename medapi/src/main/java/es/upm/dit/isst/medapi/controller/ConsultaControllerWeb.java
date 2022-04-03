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
    public String login(Model model) {
        List<Consulta> lista = new ArrayList<Consulta>();
        lista = Arrays.asList(restTemplate.getForEntity(CONSULTAMANAGER_STRING, Consulta[].class).getBody());
        model.addAttribute("consultas", lista);
        return "login"; 
        // Consulta consulta = restTemplate.getForObject(CONSULTAMANAGER_STRING + medico)      
    }

    @GetMapping("/close")
    public String close(){
        return "redirect:/medcon/login";
    }

    // @GetMapping("/enter")
    // public String enter(@RequestParam String medico){
    //     return "redirect:/medcon/agenda/{medico}";
    // }

    @GetMapping("/enter")
    public String enter(){
        return "redirect:/medcon/agenda";
    }
    
    // @GetMapping("/agenda")
    // public String lista (Model model){
    //     List<Consulta> lista = new ArrayList<Consulta>();
    //     lista = Arrays.asList(restTemplate.getForEntity(CONSULTAMANAGER_STRING, Consulta[].class).getBody());
    //     model.addAttribute("consultas", lista);
    //     return "agenda";
    // }

    @GetMapping("/agenda/{medico}")
    public String agendaMedico(Model model, @PathVariable(value ="medico") String medico){
        List<Consulta> lista = new ArrayList<Consulta>();
        lista = Arrays.asList(restTemplate.getForEntity(CONSULTAMANAGER_STRING + "medico/" + medico, Consulta[].class).getBody());
        model.addAttribute("consultas", lista);
        return "agenda";
    }

    // @GetMapping("agenda/ficha")
    // public String ficha(){
    //     return "FichaPaciente";
    // }

    @GetMapping("agenda/ficha/{nombre}")
    public String fichaPaciente(Model model, @PathVariable(value ="nombre") String nombre){
        List<Consulta> lista = new ArrayList<Consulta>();
        lista = Arrays.asList(restTemplate.getForEntity(CONSULTAMANAGER_STRING + "paciente/" + nombre, Consulta[].class).getBody());
        model.addAttribute("consultas", lista);
        return "FichaPaciente";
    }

   /* public String paciente (Model model){
        List<Consulta> paciente = new ArrayList<Consulta>();
        Consulta consulta = restTemplate.getForObject(CONSULTAMANAGER_STRING + "paciente/", Consulta.class);
        paciente.add(consulta);
        model.addAttribute("paciente", consulta);
        return "FichaPaciente";
    }*/

   /* @PostMapping("/presencia")
    public String lista (Model model) {
       
    }*/

    
}