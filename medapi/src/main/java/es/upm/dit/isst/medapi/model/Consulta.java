package es.upm.dit.isst.medapi.model;
import java.time.LocalTime;

import javax.persistence.*;
import javax.persistence.Id;

@Entity     
public class Consulta {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer idconsulta;

    private Integer DNI;
    private String nombre;
    private LocalTime cita;
    private Integer sala_espera;
    private String sala_consulta;
    private Boolean presencia;
    private String medico;
    private Boolean atendido;

    protected Consulta() {}

    public Consulta(Integer dNI, String nombre, LocalTime cita, Integer sala_espera, String sala_consulta,
            Boolean presencia, String medico, Boolean atendido) {
        DNI = dNI;
        this.nombre = nombre;
        this.cita = cita;
        this.sala_espera = sala_espera;
        this.sala_consulta = sala_consulta;
        this.presencia = presencia;
        this.medico = medico;
        this.atendido = atendido;
    }

    public Integer getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(Integer idconsulta) {
        this.idconsulta = idconsulta;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer dNI) {
        DNI = dNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getCita() {
        return cita;
    }

    public void setCita(LocalTime cita) {
        this.cita = cita;
    }

    public Integer getSala_espera() {
        return sala_espera;
    }

    public void setSala_espera(Integer sala_espera) {
        this.sala_espera = sala_espera;
    }

    public String getSala_consulta() {
        return sala_consulta;
    }

    public void setSala_consulta(String sala_consulta) {
        this.sala_consulta = sala_consulta;
    }

    public Boolean getPresencia() {
        return presencia;
    }

    public void setPresencia(Boolean presencia) {
        this.presencia = presencia;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public Boolean getAtendido() {
        return atendido;
    }

    public void setAtendido(Boolean atendido) {
        this.atendido = atendido;
    }

    @Override
    public String toString() {
        return "Consulta [DNI=" + DNI + ", atendido=" + atendido + ", cita=" + cita + ", idconsulta=" + idconsulta
                + ", medico=" + medico + ", nombre=" + nombre + ", presencia=" + presencia + ", sala_consulta="
                + sala_consulta + ", sala_espera=" + sala_espera + "]";
    }



}
