package es.upm.dit.isst.medapi.controllerWEB;

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

    // Devuelve la vista login.html
    @GetMapping("/login")
    public String login() {
        return "login";     
    }

    // Se invoca desde agenda.html. Se redirecciona a la ruta "medcon/login"
    //en vez de añadir a la ruta en la que se encuentra un /close
    @GetMapping("/close")
    public String close(){
        return "redirect:/medcon/login";
    }

    
    // Se invoca desde login.html .Solicita el parámetro "usuario" que recibe del formulario con el method=POST,
    // pide una lista(consultasMedico) de las consultas filtradas por el "usuario" recibido y lo manda a la vista agenda.html.
    // La lista lo saca del @RESTController con ruta "/consultas/medico/{usuario}".
    @RequestMapping("/agenda")
    public String agendaMedicoLogin(Model model, @RequestParam("usuario") String usuario){
        List<Consulta> lista = new ArrayList<Consulta>();
        lista = Arrays.asList(restTemplate.getForEntity(CONSULTAMANAGER_STRING + "medico/" + usuario, Consulta[].class).getBody());
        model.addAttribute("consultasMedico", lista);
        return "agenda";
    }

    // Se invoca desde agenda.html .Pide una lista(consultasPaciente) de las consultas filtradas por el {nombre} del paciente introducido en la ruta
    // y lo manda a la vista FichaPaciente.html. La lista lo saca del @RESTController con ruta "/consultas/paciente/{nombre}".     
    @GetMapping("ficha/{nombre}")
    public String fichaPaciente(Model model, @PathVariable(value ="nombre") String nombre){
        List<Consulta> lista = new ArrayList<Consulta>();
        lista = Arrays.asList(restTemplate.getForEntity(CONSULTAMANAGER_STRING + "paciente/" + nombre, Consulta[].class).getBody());
        model.addAttribute("consultasPaciente", lista);
        return "FichaPaciente";
    } // Si el paciente tuviese dos consultas, esto saldría mal 

    
    /*// Se invoca desde FichaPaciente.html. Pide la consulta por su idconsulta y la envia a salaPaciente.html
    @GetMapping("ficha/llamarPaciente/{id}")
    public String llamarPaciente(Model model, @PathVariable(value ="id") Integer id){
       Consulta consulta = restTemplate.getForEntity(CONSULTAMANAGER_STRING + id, Consulta.class).getBody();
       model.addAttribute("consultaPaciente", consulta);
       return "FichaPaciente";
    } */

    // Se invoca desde FichaPaciente.html. Pide la consulta por su idconsulta y vuelve a seguir en FichaPaciente.html
    // La Consulta lo saca del @RESTController con ruta "/consultas/atender/{id}".
    @GetMapping("ficha/cerrarConsulta/{id}")
    public String cerrarConsulta(Model model, @PathVariable(value ="id") Integer id){
       Consulta consulta = restTemplate.getForEntity(CONSULTAMANAGER_STRING + "atender/" + id, Consulta.class).getBody();
       model.addAttribute("consultasPaciente", consulta);
       return "FichaPaciente";
    }

    // Se invoca desde FichaPaciente.html. Vuelve a Agenda.html cogiendo el dato del {usuario}.
    // La Consulta lo saca del@RESTController con ruta "/consultas/medico".
    @RequestMapping("/volver/agenda")
    public String agendaMedicoVolver(Model model, @RequestParam("usuario") String usuario){
        List<Consulta> lista = new ArrayList<Consulta>();
        lista = Arrays.asList(restTemplate.getForEntity(CONSULTAMANAGER_STRING + "medico/" + usuario, Consulta[].class).getBody());
        model.addAttribute("consultasMedico", lista);
        return "agenda";
    }

    // Se invoca desde FichaPaciente.html. Devuelve la vista historialClinico.html
    @GetMapping("ficha/historialClinico")
    public String historialClinico(){
        return "historialClinico";
    }

    
    // Se invoca desde FichaPaciente.html. Devuelve la vista recetas.html
    @GetMapping("ficha/recetas")
    public String recetas(){
        return "recetas";
    }


    // Se invoca desde FichaPaciente.html. Devuelve la vista pruebasDiagnosticas.html
    @GetMapping("ficha/pruebasDiagnosticas")
    public String pruebas(){
        return "pruebasDiagnosticas";
    }


    // Se invoca desde FichaPaciente.html. Devuelve la vista nuevasCitas.html
    @GetMapping("ficha/nuevaCita")
    public String nuevaCita(){
        return "nuevasCitas";
    }



}
