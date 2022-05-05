package es.upm.dit.isst.medapi.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.medapi.model.Consulta;
import es.upm.dit.isst.medapi.model.Medico;
import es.upm.dit.isst.medapi.model.Paciente;

public interface ConsultaRepository extends CrudRepository<Consulta, Integer>{

    List<Consulta> findByPaciente(Paciente paciente);
    List<Consulta> findByMedico(Medico medico);
    Consulta findByIdconsulta(Integer idconsulta); 

    public default Consulta findByDNI(Integer dni){
        List<Consulta> consultas = (List<Consulta>) findAll();
        Consulta consulta = new Consulta();
        for(int j=0; j<consultas.size(); j++){
            if(consultas.get(j).getPaciente().getDNI().equals(dni)){
                consulta = consultas.get(j);
            }
        }
        return consulta;
    }
} 
