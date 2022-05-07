package es.upm.dit.isst.medapi.controllerREST;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import org.slf4j.*;
import es.upm.dit.isst.medapi.model.Consulta;
import es.upm.dit.isst.medapi.model.Medico;
import es.upm.dit.isst.medapi.model.Paciente;
import es.upm.dit.isst.medapi.repository.ConsultaRepository;
import es.upm.dit.isst.medapi.repository.MedicoRepository;
import es.upm.dit.isst.medapi.repository.PacienteRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


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

  // En la ruta "/consultas/{id} se muestra una consulta filtrada por id"
  @GetMapping("/consultas/{id}")
  ResponseEntity<Consulta> read(@PathVariable Integer id) {
    return consultaRepository.findById(id).map(consulta ->
       ResponseEntity.ok().body(consulta)
    ).orElse(new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND));

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
  } // ESto habría que dividirlo en otro método para que saque la consulta del paciente DE ESE DIA


  // En la ruta "/consultas/{id}" muestra la consulta del paciente filtrado por el id de la ruta con el
  // atributo atendido == true
  @GetMapping("consultas/atender/{id}")
   Consulta atendido(@PathVariable Integer id){
     Consulta consulta = consultaRepository.findByIdconsulta(id);
     consulta.setAtendido(true);
     consulta.setLlamado(false);
     consultaRepository.save(consulta);
     return consulta;
   }

  //En la ruta "/consultas/{id} se muestra una consulta filtrada por id"
  @GetMapping("/consultas/llamarPaciente/{id}")
  Consulta llamarPaciente(@PathVariable Integer id) {
    Consulta consulta = consultaRepository.findByIdconsulta(id);
    consulta.setLlamado(true);
    consultaRepository.save(consulta);
    return consulta;
  }

  @GetMapping("consultas/llamado")
    List<Consulta> readLlamados() {
    return (List<Consulta>) consultaRepository.findByLlamado();
  }
   
  //  @GetMapping("/consultas/llamarPaciente/{id}")
  // ResponseEntity<Consulta> readLlamado(@PathVariable Integer id) {
  //   return consultaRepository.findById(id).map(consulta -> {
  //     consulta.setLlamado(true);
  //     consultaRepository.save(consulta);
  //     return ResponseEntity.ok().body(consulta);
  //   }).orElse(new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND));

  // }
}
