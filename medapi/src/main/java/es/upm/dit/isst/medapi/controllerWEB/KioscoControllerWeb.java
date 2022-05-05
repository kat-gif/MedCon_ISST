package es.upm.dit.isst.medapi.controllerWEB;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import es.upm.dit.isst.medapi.model.Consulta;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/kiosco")
public class KioscoControllerWeb {
    
    public final String KIOSCOMANAGER_STRING= "http://localhost:8080/pacientes/";
    private RestTemplate restTemplate = new RestTemplate();

    // Devuelve la vista inicioKiosco.html
    @GetMapping("/inicio")
    public String inicio() {
        return "inicioKiosco";     
    }

    // Devuelve la vista RegistroKiosco.html
    @GetMapping("/registro")
    public String registro(){
        return "RegistroKiosco";
    }

    // Devuelve la vista reciboCita.html
    @GetMapping("/recibo")
    public String recibo(){
        return "reciboCita";
    }

    // Recoge del formulario de RegistroKiosco.html el DNI y lo introduce en la ruta del PacienteController para obtener 
    // la única consulta del paciente. Esta consulta "consultaPorDNI" lo manda a reciboCita.html
    @RequestMapping("registro/ok")
    public String ok(@RequestParam ("DNI") Integer dni, Model model){
        Consulta consulta = restTemplate.getForEntity(KIOSCOMANAGER_STRING + dni, Consulta.class).getBody();
        model.addAttribute("consultaPorDNI", consulta);
        return "reciboCita";
    }
}