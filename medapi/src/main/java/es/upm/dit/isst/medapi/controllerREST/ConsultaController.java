package es.upm.dit.isst.medapi.controllerREST;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import org.slf4j.*;
import es.upm.dit.isst.medapi.model.Consulta;
import es.upm.dit.isst.medapi.model.Medico;
import es.upm.dit.isst.medapi.model.Paciente;
import es.upm.dit.isst.medapi.repository.ConsultaRepository;
import es.upm.dit.isst.medapi.repository.MedicoRepository;
import es.upm.dit.isst.medapi.repository.PacienteRepository;

@RestController
public class ConsultaController {

  private final ConsultaRepository consultaRepository;
  private final MedicoRepository medicoRepository;
  private final PacienteRepository pacienteRepository;
  public static final Logger log = LoggerFactory.getLogger(ConsultaController.class);

  public ConsultaController(ConsultaRepository t, MedicoRepository m, PacienteRepository p) {
      this.consultaRepository = t;
      this.medicoRepository = m;
      this.pacienteRepository = p;
  }
  
  //En la ruta "/consultas" vuelca una lista de todo el contenido del modelo de datos Consulta
  @GetMapping("/consultas")
  List<Consulta> readAll() {
    return (List<Consulta>) consultaRepository.findAll();
  }

  //En la ruta "/consultas/medico/{usuario}" vuelca una lista de Consultas
  // filtrada por el {usuario} introducido en la ruta. De la lista de médicos busca el {usuario} 
  // y lo introduce para la búsqueda de las consultas de ese {usuario}
  @GetMapping("/consultas/medico/{usuario}")
  List<Consulta> readByMedico(@PathVariable String usuario) {
    Medico medico = (Medico) medicoRepository.findByUsuario(usuario);
    return (List<Consulta>) consultaRepository.findByMedico(medico);
  }

  
  //En la ruta "/consultas/paciente/{nombre}" vuelca una lista del contenido del modelo de datos Consulta
  // filtrada por el {nombre} del paciente introducido en la ruta
  @GetMapping("/consultas/paciente/{nombre}")
  List<Consulta> readPacientes(@PathVariable String nombre) {
    Paciente paciente = (Paciente) pacienteRepository.findByNombre(nombre);
    return (List<Consulta>) consultaRepository.findByPaciente(paciente);
  }

/*
  // @PostMapping("consultas/paciente/{nombre}/atendido")
  // ResponseEntity<Consulta> atendido(@PathVariable String nombre){
  //   return consultaRepository.findByPaciente(nombre).map(consulta ->{
  //     consulta.setAtendido(consulta.getAtendido());
  //     consultaRepository.save(consulta);
  //     return ResponseEntity.ok().body(consulta);
  //   }).orElse(new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND));
  // }*/
}
