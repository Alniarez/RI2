package uo.ri.amp.persistence.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "TMECANICOS")
public class Mecanico {
	protected Mecanico(){}
	
	@Id @GeneratedValue private Long id;
	
	private String apellidos;
	private String nombre;
	private String dni;
	
	@OneToMany(mappedBy="mecanico") private Set<Averia> averias = new HashSet<>();
	
	@OneToMany(mappedBy="mecanico") private Set<Intervencion> intervenciones = new HashSet<>();
	
	@OneToMany(mappedBy="mecanico") private Set<Asistencia> asistencias = new HashSet<>();
	
	@OneToMany(mappedBy="mecanico") private Set<Experto> expertos = new HashSet<>();
	
	
	public Mecanico(String dni) {
		super();
		this.dni = dni;
	}
	
	
	public Mecanico(String dni, String nombre, String apellidos) {
		this(dni);
		this.nombre=nombre;
		this.apellidos=apellidos;
	}

	public void addExperto(TipoVehiculo v){
		new Experto(v, this);
	}

	Set<Experto> _getExpertos() {
		return expertos;
	}

	public Set<Experto> getExpertos() {
		return new HashSet<>(expertos);
	}

	Set<Asistencia> _getAsistencias() {
		return asistencias;
	}

    public Set<Asistencia> getAsistencias() {
        return new HashSet<>(asistencias);
    }


	Set<Averia> _getAsignadas() {
		return averias;
	}

    public Set<Averia> getAsignadas() {
        return new HashSet<>(averias);
    }

	Set<Intervencion> _getIntervenciones() {
		return intervenciones;
	}

    public Set<Intervencion> getIntervenciones() {
        return new HashSet<>(intervenciones);
    }



    public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Mecanico other = (Mecanico) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Mecanico [dni=" + dni + ", apellidos=" + apellidos + ", nombre=" + nombre + "]";
	}


	public long getId() {
		return id;
	}

	
	
}
