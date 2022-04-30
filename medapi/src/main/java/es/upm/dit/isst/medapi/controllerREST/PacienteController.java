package es.upm.dit.isst.medapi.controllerREST;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import org.slf4j.*;
import es.upm.dit.isst.medapi.model.Paciente;
import es.upm.dit.isst.medapi.repository.PacienteRepository;

@RestController
public class PacienteController {

  private final PacienteRepository pacienteRepository;
  public static final Logger log = LoggerFactory.getLogger(PacienteController.class);

  public PacienteController(PacienteRepository t) {
      this.pacienteRepository = t;

  }
  
  //En la ruta "/pacientes" vuelca una lista de todo el contenido del modelo de datos Pacientes
  @GetMapping("/pacientes")
  List<Paciente> readAll() {
    return (List<Paciente>) pacienteRepository.findAll();
  }
  
 /* //En la ruta "/pacientes/{nombre}" muestra el Paciente
  // filtrado por el {nombre} introducido en la ruta
  @GetMapping("/pacientes/{nombre}")
  ResponseEntity<Paciente> readByPaciente(@PathVariable String nombre) {
    return pacienteRepository.findById(nombre).map (paciente ->
          ResponseEntity.ok().body(paciente)
    ).orElse(new ResponseEntity<Paciente>(HttpStatus.NOT_FOUND));
  }

  //En la ruta "/pacientes/nombre/{nombre}" vuelca una lista del contenido del modelo de datos Paciente
  // filtrada por el {nombre} introducido en la ruta
  @GetMapping("/pacientes/{dni}")
  Paciente readByDni(@PathVariable String dNI) {
    Integer dni = Integer.parseInt(dNI);
    return (Paciente) pacienteRepository.findByDNI(dni);
  }*/
}