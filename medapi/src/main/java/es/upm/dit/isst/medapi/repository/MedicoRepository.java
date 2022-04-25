package es.upm.dit.isst.medapi.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.medapi.model.Medico;

public interface MedicoRepository extends CrudRepository<Medico, String>{

    List<Medico> findByNombre(String nombre);
    Medico findByUsuario(String usuario);
}