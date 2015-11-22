package uo.ri.amp.persistence.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "TTIPOSVEHICULO")
public class TipoVehiculo {

	protected TipoVehiculo(){}
	
	@Id @GeneratedValue private Long id;
	
	private String nombre;
	private double precioHora;
	
	@OneToMany(mappedBy="tipo") private Set<Vehiculo> vehiculos = new HashSet<>();
	
	private int horasMaestria;
	
	@OneToMany(mappedBy="tipoVehiculo") private Set<ContenidoCurso> contenidoCurso = new HashSet<>();
	
	@OneToMany(mappedBy="tipoVehiculo") private Set<Experto> expertos = new HashSet<>();
	
	public TipoVehiculo(String nombre) {
		this.nombre = nombre;
	}
	
	Set<Experto> _getExpertos() {
		return expertos;
	}

    public Set<Experto> getExpertos() {
        return new HashSet<>(expertos);
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

	Set<ContenidoCurso> _getContenidoCurso() {
		return contenidoCurso;
	}

	public Set<ContenidoCurso> getContenidoCurso() {
		return new HashSet<>(contenidoCurso);
	}

	Set<Vehiculo> _getVehiculos() {
		return vehiculos;
	}

    public Set<Vehiculo> getVehiculos() {
        return new HashSet<>(vehiculos);
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
