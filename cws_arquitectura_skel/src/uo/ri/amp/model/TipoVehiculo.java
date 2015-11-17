package uo.ri.amp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "TTIPOSVEHICULO")
public class TipoVehiculo {
	
	TipoVehiculo(){}
	
	@Id @GeneratedValue private Long id;
	
	private String nombre;
	private double precioHora;
	
	@OneToMany(mappedBy="tipo") private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
	
	private int horasMaestria;
	
	@OneToMany(mappedBy="tipoVehiculo") private Set<ContenidoCurso> contenidoCurso = new HashSet<ContenidoCurso>();
	
	@OneToMany(mappedBy="tipoVehiculo") private Set<Experto> expertos = new HashSet<Experto>();
	
	public TipoVehiculo(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Set<Experto> getExpertos() {
		return expertos;
	}

	public int getHorasMaestria() {
		return horasMaestria;
	}

	public void setHorasMaestria(int horasMaestria) {
		this.horasMaestria = horasMaestria;
	}

	public Long getId() {
		return id;
	}

	public Set<ContenidoCurso> getContenidoCurso() {
		return contenidoCurso;
	}

	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public TipoVehiculo(String nombre, double precioHora) {
		this(nombre);
		this.precioHora=precioHora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		TipoVehiculo other = (TipoVehiculo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public double getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}

	public String getNombre() {
		return nombre;
	}

	
	
}
