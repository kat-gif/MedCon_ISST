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

    @GetMapping("/close")
    public String close(){
        return "redirect:/medcon/login";
    }

    @RequestMapping("/agenda")
    public String agendaMedicoLogin(Model model, @RequestParam("medico") String medico){
        List<Consulta> lista = new ArrayList<Consulta>();
        lista = Arrays.asList(restTemplate.getForEntity(CONSULTAMANAGER_STRING + "medico/" + medico, Consulta[].class).getBody());
        model.addAttribute("consultasMedico", lista);
        return "agenda";
    }

    // Pide una lista de las consultas filtradas por el {nombre} del paciente introducido en la ruta y lo manda 
    @GetMapping("ficha/{nombre}")
    public String fichaPaciente(Model model, @PathVariable(value ="nombre") String nombre){
        List<Consulta> lista = new ArrayList<Consulta>();
        lista = Arrays.asList(restTemplate.getForEntity(CONSULTAMANAGER_STRING + "paciente/" + nombre, Consulta[].class).getBody());
        model.addAttribute("consultasPaciente", lista);
        return "FichaPaciente";
    }

    @GetMapping("ficha/historialClinico")
    public String historialClinico(){
        return "historialClinico";
    }

    @GetMapping("ficha/recetas")
    public String recetas(){
        return "recetas";
    }

    @GetMapping("ficha/pruebasDiagnosticas")
    public String pruebas(){
        return "pruebasDiagnosticas";
    }

    @GetMapping("ficha/nuevaCita")
    public String nuevaCita(){
        return "nuevasCitas";
    }
}