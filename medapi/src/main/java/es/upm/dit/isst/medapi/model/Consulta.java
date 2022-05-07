package es.upm.dit.isst.medapi.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.*;

@Entity     
public class Consulta {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer idconsulta;

    // esta es la FK del atributo "usuario" de la tabla Medico
    @JoinColumn
    @ManyToOne 
    private Medico medico;

    // esta es la FK del atributo "nombre" de la tabla Paciente
    @JoinColumn
    @ManyToOne
    private Paciente paciente;

    private LocalTime hora;
    private LocalDate fecha;
    private Integer sala_espera;
    private String sala_consulta;
    private Boolean atendido;
    private Duration t_consulta;
    private String observaciones;
    private String id_espera;
    private Boolean presencia;
    private Boolean llamado = false;    //esto tiene todo puesto. incluso se ha rellenado en la tabla

    public Consulta() {}

    public Consulta(Medico medico, Paciente paciente, LocalTime hora, LocalDate fecha,
            Integer sala_espera, String sala_consulta, Boolean presencia, Duration t_consulta, String observaciones,
            Boolean atendido) {

        this.medico = medico;
        this.paciente = paciente;
        this.hora = hora;
        this.fecha = fecha;
        this.sala_espera = sala_espera;
        this.sala_consulta = sala_consulta;
        this.atendido = atendido;
        this.t_consulta = t_consulta;
        this.observaciones = observaciones;
        this.presencia = presencia;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Boolean getPresencia() {
        return presencia;
    }

    public void setPresencia(Boolean presencia) {
        this.presencia = presencia;
    }

    public Integer getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(Integer idconsulta) {
        this.idconsulta = idconsulta;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public Boolean getAtendido() {
        return atendido;
    }

    public void setAtendido(Boolean atendido) {
        this.atendido = atendido;
    }

    public Duration getT_consulta() {
        return t_consulta;
    }

    public void setT_consulta(Duration t_consulta) {
        this.t_consulta = t_consulta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getId_espera() {
        return this.getSala_espera().toString() + this.getSala_consulta() + "-" + this.getIdconsulta().toString();
    }

    public void setId_espera(String id_espera) {
        this.id_espera = id_espera;
    }

    public Boolean getLlamado() {
        return llamado;
    }

    public void setLlamado(Boolean llamado) {
        this.llamado = llamado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((atendido == null) ? 0 : atendido.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((hora == null) ? 0 : hora.hashCode());
        result = prime * result + ((id_espera == null) ? 0 : id_espera.hashCode());
        result = prime * result + ((idconsulta == null) ? 0 : idconsulta.hashCode());
        result = prime * result + ((llamado == null) ? 0 : llamado.hashCode());
        result = prime * result + ((medico == null) ? 0 : medico.hashCode());
        result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
        result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
        result = prime * result + ((presencia == null) ? 0 : presencia.hashCode());
        result = prime * result + ((sala_consulta == null) ? 0 : sala_consulta.hashCode());
        result = prime * result + ((sala_espera == null) ? 0 : sala_espera.hashCode());
        result = prime * result + ((t_consulta == null) ? 0 : t_consulta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Consulta other = (Consulta) obj;
        if (atendido == null) {
            if (other.atendido != null)
                return false;
        } else if (!atendido.equals(other.atendido))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (hora == null) {
            if (other.hora != null)
                return false;
        } else if (!hora.equals(other.hora))
            return false;
        if (id_espera == null) {
            if (other.id_espera != null)
                return false;
        } else if (!id_espera.equals(other.id_espera))
            return false;
        if (idconsulta == null) {
            if (other.idconsulta != null)
                return false;
        } else if (!idconsulta.equals(other.idconsulta))
            return false;
        if (llamado == null) {
            if (other.llamado != null)
                return false;
        } else if (!llamado.equals(other.llamado))
            return false;
        if (medico == null) {
            if (other.medico != null)
                return false;
        } else if (!medico.equals(other.medico))
            return false;
        if (observaciones == null) {
            if (other.observaciones != null)
                return false;
        } else if (!observaciones.equals(other.observaciones))
            return false;
        if (paciente == null) {
            if (other.paciente != null)
                return false;
        } else if (!paciente.equals(other.paciente))
            return false;
        if (presencia == null) {
            if (other.presencia != null)
                return false;
        } else if (!presencia.equals(other.presencia))
            return false;
        if (sala_consulta == null) {
            if (other.sala_consulta != null)
                return false;
        } else if (!sala_consulta.equals(other.sala_consulta))
            return false;
        if (sala_espera == null) {
            if (other.sala_espera != null)
                return false;
        } else if (!sala_espera.equals(other.sala_espera))
            return false;
        if (t_consulta == null) {
            if (other.t_consulta != null)
                return false;
        } else if (!t_consulta.equals(other.t_consulta))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Consulta [atendido=" + atendido + ", fecha=" + fecha + ", hora=" + hora + ", id_espera=" + id_espera
                + ", idconsulta=" + idconsulta + ", llamado=" + llamado + ", medico=" + medico + ", observaciones="
                + observaciones + ", paciente=" + paciente + ", presencia=" + presencia + ", sala_consulta="
                + sala_consulta + ", sala_espera=" + sala_espera + ", t_consulta=" + t_consulta + "]";
    }

    
    
}