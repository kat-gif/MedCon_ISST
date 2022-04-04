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
            repository.save(new Consulta(1234567, "Katia Alvarado Peláez", LocalTime.of(10,43,00), 1, "B",true,"Monica@medico.es","",null));
			repository.save(new Consulta(2345678, "Alvaro Martín Brito", LocalTime.of(10,50,00), 1, "B",true,"Monica@medico.es","",null));
			repository.save(new Consulta(3345678, "Marina Blanco Gil", LocalTime.of(10,57,00), 1, "A",true,"Juanfrancisco@medico.es","",null));
			repository.save(new Consulta(45678912, "Fernando González Fernández", LocalTime.of(11,05,00), 2, "C",true,"Ana@medico.es","",null));
			repository.save(new Consulta(56789123, "Rafael Aldaz Aro", LocalTime.of(11,15,00), 2, "C",false,"Ana@medico.es","",null));
			repository.save(new Consulta(66789123, "Oscar Arroyo Calderón", LocalTime.of(11,00,00), 1, "B",true,"Monica@medico.es","",null));
			repository.save(new Consulta(33456780, "Sara Torres Guzmán", LocalTime.of(11,10,00), 1, "A",false,"Juanfrancisco@medico.es","",null));
			repository.save(new Consulta(68789123, "Oscar Arroyo Pascual", LocalTime.of(11,10,00), 1, "B",false,"Monica@medico.es","",null));
			repository.save(new Consulta(82789123, "Pilar Casillas Ramos", LocalTime.of(11,15,00), 1, "B",true,"Monica@medico.es","",null));
			repository.save(new Consulta(65439123, "Gonzalo Trejo Torres", LocalTime.of(11,20,00), 1, "B",false,"Monica@medico.es","",null));
			repository.save(new Consulta(67149123, "Luis Hurtado Ronaldo", LocalTime.of(11,30,00), 1, "B",false,"Monica@medico.es","",null));
			repository.save(new Consulta(66777613, "Paco Prieto Carmona", LocalTime.of(11,45,00), 1, "B",false,"Monica@medico.es","",null));
			repository.save(new Consulta(68789123, "Laura Gómez Pascual", LocalTime.of(12,00,00), 1, "B",false,"Monica@medico.es","",null));
	    };
	}
}
