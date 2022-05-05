package es.upm.dit.isst.medapi.controllerWEB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller

public class PantallaEsperaControllerWeb {
    
    public final String PANTALLAMANAGER_STRING= "http://localhost:8080/pacientes/";
    private RestTemplate restTemplate = new RestTemplate();

    // Devuelve la salaEspera.html
    @GetMapping("/pantalla")
    public String pantalla() {
        return "salaEspera";     
    }
}
