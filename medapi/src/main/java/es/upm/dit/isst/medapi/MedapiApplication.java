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
			repository.save(new Consulta(1234567, "Katia Alvarado Pelaez", LocalTime.of(10,43,12), 1, "B",null,"Monica@medico.es",null));
			repository.save(new Consulta(2345678, "Alvaro Martin Brito", LocalTime.of(10,50,12), 1, "A",null,"Monica@medico.es",null));
			repository.save(new Consulta(2345678, "Alvaro Martin Brito", LocalTime.of(10,50,12), 1, "A",null,"Monica@medico.es",null));
	

	    };
	}
}
