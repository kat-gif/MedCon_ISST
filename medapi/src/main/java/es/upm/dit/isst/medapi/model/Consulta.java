package es.upm.dit.isst.medapi.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Consulta {

    @Id
    @Column(unique = true, nullable = false)
    private Integer idconsulta;

    private Integer idscon;
    private String idsesp;
    private LocalDate fecha;
    private LocalTime horaini;
    private LocalTime horafin;
    private Duration tconsulta;
    private String medico;
    private String paciente;

    public Consulta() {
    }

    public Integer getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(Integer idconsulta) {
        this.idconsulta = idconsulta;
    }

    public Integer getIdscon() {
        return idscon;
    }

    public void setIdscon(Integer idscon) {
        this.idscon = idscon;
    }

    public String getIdsesp() {
        return idsesp;
    }

    public void setIdsesp(String idsesp) {
        this.idsesp = idsesp;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraini() {
        return horaini;
    }

    public void setHoraini(LocalTime horaini) {
        this.horaini = horaini;
    }

    public LocalTime getHorafin() {
        return horafin;
    }

    public void setHorafin(LocalTime horafin) {
        this.horafin = horafin;
    }

    public Duration getTconsulta() {
        return tconsulta;
    }

    public void setTconsulta(Duration tconsulta) {
        this.tconsulta = tconsulta;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

}
