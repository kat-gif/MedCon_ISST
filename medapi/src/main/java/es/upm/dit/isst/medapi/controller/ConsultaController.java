package es.upm.dit.isst.medapi.controller;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/consultas")
  List<Consulta> readAll() {
    return (List<Consulta>) consultaRepository.findAll();
  }

  @GetMapping("/consultas/medico/{id}")
  List<Consulta> readMedico(@PathVariable String id) {
    return (List<Consulta>) consultaRepository.findByMedico(id);
  }

}
