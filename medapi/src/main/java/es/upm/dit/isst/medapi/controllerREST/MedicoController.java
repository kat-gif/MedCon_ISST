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
}