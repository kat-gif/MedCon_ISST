package es.upm.dit.isst.medapi.controllerWEB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import es.upm.dit.isst.medapi.model.Consulta;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/kiosco")
public class KioscoControllerWeb {
    
    //public final String PACIENTEMANAGER_STRING= "http://localhost:8080/pacientes/";
    public final String CONSULTAMANAGER_STRING= "http://localhost:8080/consultas/";
    private RestTemplate restTemplate = new RestTemplate();

    // Devuelve la vista inicioKiosco.html
    @GetMapping("/inicio")
    public String inicio() {
        return "inicioKiosco";     
    }

    @GetMapping("/registro")
    public String registro(){
        return "RegistroKiosco";
    }

    @GetMapping("/recibo")
    public String recibo(){
        return "reciboCita";
    }

    // EN PROCESO ... 
    @RequestMapping("registro/ok")
    public String ok(@RequestParam ("DNI") String dni, Model model) {
        List<Consulta> lista = new ArrayList<Consulta>();
        lista = Arrays.asList(restTemplate.getForEntity(CONSULTAMANAGER_STRING, Consulta[].class).getBody());
        model.addAttribute("todasConsultas", lista);
        return "registroKiosco";
    }



}