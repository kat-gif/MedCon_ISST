package es.upm.dit.isst.medapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.medapi.model.Consulta;

public interface ConsultaRepository extends CrudRepository<Consulta, Integer>{

    List<Consulta> findByNombre(String nombre);

    Optional<Consulta> findById(Integer idconsulta);
}
