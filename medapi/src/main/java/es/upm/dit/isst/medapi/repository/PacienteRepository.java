package es.upm.dit.isst.medapi.repository;

//import java.util.List;
import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.medapi.model.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, String>{

    Paciente findByNombre(String nombre);
    //List<Paciente> findByDNI(Integer dNI);
    Paciente findByDNI(Integer dNI);
}