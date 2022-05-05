package es.upm.dit.isst.medapi.controllerREST;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

import org.slf4j.*;

import es.upm.dit.isst.medapi.model.Consulta;
import es.upm.dit.isst.medapi.model.Paciente;
import es.upm.dit.isst.medapi.repository.ConsultaRepository;
import es.upm.dit.isst.medapi.repository.PacienteRepository;

@RestController
public class PacienteController {

  private final PacienteRepository pacienteRepository;
  private final ConsultaRepository consultaRepository;
  public static final Logger log = LoggerFactory.getLogger(PacienteController.class);

  public PacienteController(ConsultaRepository t, PacienteRepository p) {
    this.consultaRepository = t;
    this.pacienteRepository = p;
}
  
  //En la ruta "/pacientes" vuelca una lista de todo el contenido del modelo de datos Pacientes
  @GetMapping("/pacientes")
  List<Paciente> readAll() {
    return (List<Paciente>) pacienteRepository.findAll();
  }
  
  // En la ruta "/pacientes/{dni}" saca una Consulta filtrada por el dni introducido en la ruta. 
  // Se hace uso del método findByDNI implementado en ConsultaRepository
  @GetMapping("/pacientes/{dni}")
  Consulta readByDni(@PathVariable String dni) {
    Integer dNI = Integer.parseInt(dni);
    Consulta consulta = consultaRepository.findByDNI(dNI);
    consulta.setPresencia(true);
    consultaRepository.save(consulta);
    return consulta;
  }
}