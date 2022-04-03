package es.upm.dit.isst.medapi;

import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.upm.dit.isst.medapi.model.Consulta;
import es.upm.dit.isst.medapi.repository.ConsultaRepository;

@SpringBootApplication
public class MedapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MedapiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo (ConsultaRepository repository) {
		return (args) -> {
			// guarda algunas consultas ya registradas al iniciar la aplicación.
            repository.save(new Consulta(1234567, "Katia Alvarado Pelaez", LocalTime.of(10,43,12), 1, "B",null,"Monica@medico.es","",null));
			repository.save(new Consulta(2345678, "Alvaro Martin Brito", LocalTime.of(10,50,12), 1, "B",null,"Monica@medico.es","",null));
			repository.save(new Consulta(3345678, "Marina Blanco Gil", LocalTime.of(10,57,00), 1, "A",null,"Juanfrancisco@medico.es","",null));
			repository.save(new Consulta(45678912, "Fernando Gonzalez Fernandez", LocalTime.of(11,05,00), 2, "C",true,"Ana@medico.es","",null));
			repository.save(new Consulta(56789123, "Rafael Aldaz Aro", LocalTime.of(11,15,00), 2, "C",false,"Ana@medico.es","",null));
			repository.save(new Consulta(56789123, "Oscar Arroyo Calderon", LocalTime.of(11,01,00), 1, "B",false,"Monica@medico.es","",null));

	    };
	}
}
