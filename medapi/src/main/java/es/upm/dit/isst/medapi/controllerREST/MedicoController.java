package es.upm.dit.isst.medapi.controllerREST;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import org.slf4j.*;
import es.upm.dit.isst.medapi.model.Medico;
import es.upm.dit.isst.medapi.repository.MedicoRepository;

@RestController
public class MedicoController {

  private final MedicoRepository medicoRepository;
  public static final Logger log = LoggerFactory.getLogger(MedicoController.class);

  public MedicoController(MedicoRepository t) {
      this.medicoRepository = t;

  }
  
  //En la ruta "/medicos" vuelca una lista de todo el contenido del modelo de datos Medico
  @GetMapping("/medicos")
  List<Medico> readAll() {
    return (List<Medico>) medicoRepository.findAll();
  }
  
  /*//En la ruta "/medicos/usuario/{usuario}" vuelca una lista del contenido del modelo de datos Medico
  // filtrada por el {usuario} introducido en la ruta
  @GetMapping("/medicos/usuario/{usuario}")
  List<Medico> readByMedico(@PathVariable String usuario) {
    return (List<Medico>) medicoRepository.findByUsuario(usuario);
  }*/

}