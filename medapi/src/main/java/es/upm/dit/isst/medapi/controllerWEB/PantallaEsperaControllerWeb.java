package es.upm.dit.isst.medapi.controllerWEB;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import es.upm.dit.isst.medapi.model.Consulta;

@Controller

public class PantallaEsperaControllerWeb {
    
    public final String MANAGER_STRING= "http://localhost:8080/";
    private RestTemplate restTemplate = new RestTemplate();
    
    // Devuelve la vista INICIO.html. NO está relacionado con la Pantalla de espera
    @GetMapping("/")
    public String inicio() {
        return "INICIO";     
    }

    // Devuelve la salaEspera.html
    @GetMapping("/pantalla")
    public String pantalla(Model model) {
        List<Consulta> lista = new ArrayList<Consulta>();
		lista = Arrays.asList(restTemplate.getForEntity(MANAGER_STRING + "consultas/llamado", Consulta[].class).getBody());
        model.addAttribute("consultas", lista);
        return "salaEspera";     
    }
}
