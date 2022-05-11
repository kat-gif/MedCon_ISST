package es.upm.dit.isst.medapi;

//Librerías Java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

//Librerías Spring
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

//Importación Modelo y Repositorios
import es.upm.dit.isst.medapi.model.Medico;
import es.upm.dit.isst.medapi.model.Paciente;
import es.upm.dit.isst.medapi.model.Consulta;
import es.upm.dit.isst.medapi.repository.ConsultaRepository;
import es.upm.dit.isst.medapi.repository.MedicoRepository;
import es.upm.dit.isst.medapi.repository.PacienteRepository;


  @SpringBootTest
public class MedapiApplicationTests {

	@Autowired
	private MedicoRepository mrepo;
	@Autowired
	private ConsultaRepository consrepo;
	@Autowired
	private PacienteRepository pacrepo;
	
	@Test
	final void testMedico() {
		
		//Almacenamiento de Datos
		Medico m = new Medico();
		m.setUsuario("Monica@medico.es");
		m.setNombre("Mónica Gómez Hurtado");
		m.setContraseña("monica");
		m.setEspecialidad("Pediatría");
		
		mrepo.save(m);

		//Condiciones a comprobar
		Medico medico = mrepo.findByUsuario("Monica@medico.es");
		assertEquals(medico.getUsuario(), m.getUsuario());
		assertEquals(medico.getNombre(), m.getNombre());
		assertEquals(medico.getContraseña(), m.getContraseña());
		assertEquals(medico.getEspecialidad(), m.getEspecialidad());
		}
		
	@Test
	final void testPaciente(){
			
		//Almacenamiento de Datos
		Paciente p = new Paciente();
		p.setNombre("Katia Alvarado Peláez");
		p.setDNI(10111111); 
		

		pacrepo.save(p);

	   //Condiciones a comprobar
		Paciente paciente = pacrepo.findByDNI(10111111);
		assertEquals(paciente.getNombre(), p.getNombre());
		assertEquals(paciente.getDNI(), p.getDNI());

		//Almacenamiento de Datos
		Paciente p2 = new Paciente();
		p2.setNombre("Katia Alvarado Peláez");
		p2.setDNI(10111123); 

		pacrepo.save(p2);

		//Condiciones a comprobar
		assertNotEquals(paciente.getDNI(), p2.getDNI());
		assertEquals(paciente.getNombre(), p2.getNombre());
	}

	@Test
	final void testConsulta() {

		//Almacenamiento de Datos
		Medico me = new Medico();
		Paciente pe = new Paciente();
		Consulta c = new Consulta();

        me.setUsuario("Monica@medico.es");
		me.setNombre("Mónica Gómez Hurtado");
		me.setContraseña("monica");
		me.setEspecialidad("Pediatría");
        c.setMedico(me);

		pe.setNombre("Katia Alvarado Peláez");
		pe.setDNI(10111111); 
		c.setPaciente(pe);

		c.setIdconsulta(1);
		c.setHora(LocalTime.of(9, 00,00));
		c.setFecha(LocalDate.of(2022, 04, 24));
		c.setSala_espera(1);
		c.setSala_consulta("A");
		c.setPresencia(false);
		c.setId_espera("4");
		c.setIdconsulta(2);
		c.setObservaciones("Primera consulta");
		c.setAtendido(false);
		
		consrepo.save(c);

		//Condiciones a comprobar
		Consulta consulta = consrepo.findByDNI(10111111);
		assertEquals(consulta.getHora(), c.getHora());
		assertEquals(consulta.getFecha(), c.getFecha());
		assertEquals(consulta.getSala_consulta(), c.getSala_consulta());
		assertEquals(consulta.getSala_espera(), c.getSala_espera());
		assertEquals(consulta.getPresencia(), c.getPresencia());
		assertEquals(consulta.getAtendido(), c.getAtendido());
		assertEquals(consulta.getId_espera(), c.getId_espera());
		assertEquals(consulta.getIdconsulta(), c.getIdconsulta());
	}

		@Test
    final void testListaDeConsultas() {
        //Almacenamiento de Datos
        Medico me = new Medico();
        me.setUsuario("Marina@medico.es");
        me.setNombre("Marina Blanco Gil");
        me.setContraseña("marina");
        me.setEspecialidad("Primaria");

        mrepo.save(me);



		Paciente p8 = new Paciente();
		p8.setNombre("Sergio Camarón Velázquez");
		p8.setDNI(88888888); 
		pacrepo.save(p8);
		
		Paciente p9 = new Paciente();
		p9.setNombre("Gonzalo Trejo Torres");
		p9.setDNI(99999999); 
		pacrepo.save(p8);

		Paciente p10 = new Paciente();
		p10.setNombre("Luis Hurtado Ronaldo");
		p10.setDNI(11111110); 
		pacrepo.save(p10);

		Paciente p7 = new Paciente();
		p7.setNombre("Pilar Casillas Ramos");
		p7.setDNI( 77777777); 
		pacrepo.save(p7);
	

		List <Consulta> listaPacientes = new ArrayList<Consulta>();
		listaPacientes.add(  new Consulta(me,p7, LocalTime.of(10,00,00), LocalDate.of(2020, 04, 24), 1, "B",true," Ha pasado el covid", false));
		listaPacientes.add(  new Consulta(me, p8, LocalTime.of(10,10,00), LocalDate.of(2020, 04, 24), 1, "B",true," Ha pasado el covid", false));
		listaPacientes.add(  new Consulta(me, p9, LocalTime.of(10,20,00), LocalDate.of(2020, 04, 24), 1, "B",false," Ha pasado el covid", false));
	    listaPacientes.add(  new Consulta(me, p10, LocalTime.of(10,30,00), LocalDate.of(2020, 04, 24), 1, "B",true," Ha pasado el covid", false));

		        consrepo.saveAll(listaPacientes); //no se si hace falta

        		Medico medico = mrepo.findByUsuario("Marina@medico.es");   
        		assertEquals(medico.getNombre(), me.getNombre());
		        assertEquals(medico.getEspecialidad(), me.getEspecialidad());
		
       			List <Consulta> agenda = consrepo.findByMedico(medico);
				assertTrue(agenda.containsAll(listaPacientes));
			
	}   
}
 