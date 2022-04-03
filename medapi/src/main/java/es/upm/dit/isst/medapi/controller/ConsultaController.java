package es.upm.dit.isst.medapi.controller;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import org.slf4j.*;
import es.upm.dit.isst.medapi.model.Consulta;
import es.upm.dit.isst.medapi.repository.ConsultaRepository;

@RestController
public class ConsultaController {

  private final ConsultaRepository consultaRepository;
  public static final Logger log = LoggerFactory.getLogger(ConsultaController.class);

  public ConsultaController(ConsultaRepository t) {
      this.consultaRepository = t;

  }
  
  //En la ruta "/consultas" vuelca una lista de todo el contenido del modelo de datos Consulta
  @GetMapping("/consultas")
  List<Consulta> readAll() {
    return (List<Consulta>) consultaRepository.findAll();
  }
  
  //En la ruta "/consultas/medico/{medico}" vuelca una lista del contenido del modelo de datos Consulta
  // filtrada por el {medico} introducido en la ruta
  @GetMapping("/consultas/medico/{medico}")
  List<Consulta> readByMedico(@PathVariable String medico) {
    return (List<Consulta>) consultaRepository.findByMedico(medico);
  }

  //En la ruta "/consultas/paciente/{nombre}" vuelca una lista del contenido del modelo de datos Consulta
  // filtrada por el {nombre} del paciente introducido en la ruta
  @GetMapping("/consultas/paciente/{nombre}")
  List<Consulta> readPacientes(@PathVariable String nombre) {
    return (List<Consulta>) consultaRepository.findByNombre(nombre);
  }

  // @PostMapping("consultas/paciente/{nombre}/atendido")
  // ResponseEntity<Consulta> atendido(@PathVariable String nombre){
  //   return consultaRepository.findByPaciente(nombre).map(consulta ->{
  //     consulta.setAtendido(consulta.getAtendido());
  //     consultaRepository.save(consulta);
  //     return ResponseEntity.ok().body(consulta);
  //   }).orElse(new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND));
  // }
}
