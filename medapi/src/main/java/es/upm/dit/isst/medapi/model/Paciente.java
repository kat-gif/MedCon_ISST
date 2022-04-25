package es.upm.dit.isst.medapi.model;

import javax.persistence.*;

@Entity
public class Paciente {
    
    @Id
    private String nombre;

    private Integer DNI;

    protected Paciente() {}

    public Paciente(String nombre, Integer dNI) {
        this.nombre = nombre;
        DNI = dNI;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer dNI) {
        DNI = dNI;
    }

    @Override
    public String toString() {
        return "Paciente [DNI=" + DNI + ", nombre=" + nombre + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
        Paciente other = (Paciente) obj;
        if (DNI == null) {
            if (other.DNI != null)
                return false;
        } else if (!DNI.equals(other.DNI))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    
    
}
