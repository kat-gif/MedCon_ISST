package es.upm.dit.isst.medapi.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.medapi.model.Consulta;
import es.upm.dit.isst.medapi.model.Medico;
import es.upm.dit.isst.medapi.model.Paciente;

public interface ConsultaRepository extends CrudRepository<Consulta, Integer>{

    //List<Consulta> findByNombre(String nombre);
    List<Consulta> findByPaciente(Paciente paciente);
    List<Consulta> findByMedico(Medico medico);
}
