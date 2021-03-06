package es.upm.dit.isst.medapi;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.upm.dit.isst.medapi.model.Consulta;
import es.upm.dit.isst.medapi.model.Medico;
import es.upm.dit.isst.medapi.model.Paciente;
import es.upm.dit.isst.medapi.repository.ConsultaRepository;
import es.upm.dit.isst.medapi.repository.MedicoRepository;
import es.upm.dit.isst.medapi.repository.PacienteRepository;

@SpringBootApplication
public class MedapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MedapiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo (PacienteRepository Prepository, MedicoRepository Mrepository, ConsultaRepository Crepository){
		return (args) -> {

			Paciente paciente1 = new Paciente("Katia Alvarado Peláez", 10111111);
			Prepository.save (paciente1);
			Paciente paciente2 = new Paciente("Alvaro Martín Brito", 22222222);
			Prepository.save(paciente2);
			Paciente paciente3 = new Paciente ("Fernando González Fernández", 33333333);
			Prepository.save(paciente3);
			Paciente paciente4 = new Paciente ("Rafael Aldaz Aro", 44444444);
			Prepository.save(paciente4);
			Paciente paciente5 = new Paciente("Oscar Arroyo Calderón", 55555555);
			Prepository.save(paciente5);
			Paciente paciente6 = new Paciente("Lucia Montés Hernández", 66666666);
			Prepository.save(paciente6);
			Paciente paciente7 = new Paciente("Pilar Casillas Ramos", 77777777);
			Prepository.save(paciente7);
			Paciente paciente8 = new Paciente("Sergio Camarón Velázquez", 88888888);
			Prepository.save(paciente8);
			Paciente paciente9 = new Paciente("Gonzalo Trejo Torres", 99999999);
			Prepository.save(paciente9);
			Paciente paciente10 = new Paciente("Luis Hurtado Ronaldo", 11111110);
			Prepository.save(paciente10);
			Paciente paciente11 = new Paciente("Paco Prieto Carmona", 11111111);
			Prepository.save(paciente11);
			Paciente paciente12 = new Paciente("Laura Gómez Pascual", 11111112);
			Prepository.save(paciente12);

			Medico medico1 = new Medico ("Monica@medico.es", "Mónica Gómez Hurtado", "monica", "Pediatría");
			Mrepository.save(medico1);
			Medico medico2 = new Medico ("Marina@medico.es", "Marina Blanco Gil", "marina", "Primaria");
			Mrepository.save(medico2);
			Medico medico3 = new Medico ("Juanfran@medico.es", "Juan Francisco Vara Sánchez", "juanfran", "Ginecología");
			Mrepository.save(medico3);


			Crepository.save(new Consulta(medico1, paciente1, LocalTime.of(9,00,00), LocalDate.of(2022, 04, 24), 1, "A",false, "Primera consulta",false));
			Crepository.save(new Consulta(medico1, paciente2, LocalTime.of(9,10,00), LocalDate.of(2022, 04, 24), 1, "A",false, "Revisión",false));
			Crepository.save(new Consulta(medico1, paciente3, LocalTime.of(9,15,00), LocalDate.of(2022, 04, 24), 1, "A",false, "Pauta completa",false));
			Crepository.save(new Consulta(medico1, paciente4, LocalTime.of(9,25,00), LocalDate.of(2022, 04, 24), 1, "A",false, "Revisión",false));
			Crepository.save(new Consulta(medico1, paciente5, LocalTime.of(9,35,00), LocalDate.of(2022, 04, 24), 1, "A",false, "Revisión",false));
			Crepository.save(new Consulta(medico1, paciente6, LocalTime.of(9,45,00), LocalDate.of(2022, 04, 24), 1, "A",false, "Pauta completa",false));
			Crepository.save(new Consulta(medico1, paciente7, LocalTime.of(9,55,00), LocalDate.of(2022, 04, 24), 1, "A",false, "Revisión",false));
			Crepository.save(new Consulta(medico1, paciente8, LocalTime.of(10,05,00), LocalDate.of(2022, 04, 24), 1, "A",false, "Revisión",false));
			Crepository.save(new Consulta(medico2, paciente9, LocalTime.of(10,00,00), LocalDate.of(2022, 04, 24), 2, "B",false, " Pauta completa", false));
			Crepository.save(new Consulta(medico2, paciente10, LocalTime.of(10,10,00), LocalDate.of(2022, 04, 24), 2, "B",false, " Ha pasado el covid", false));
			Crepository.save(new Consulta(medico2, paciente11, LocalTime.of(10,20,00), LocalDate.of(2022, 04, 24), 2, "B",false, " Ha pasado el covid", false));
			Crepository.save(new Consulta(medico3, paciente12, LocalTime.of(10,30,00), LocalDate.of(2022, 04, 24), 2, "C",false, " Ha pasado el covid", false));
			
		};
	}

}
