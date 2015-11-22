package uo.ri.amp.persistence.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import uo.ri.amp.persistence.model.types.Address;

@Entity
@Table(name="TCLIENTES")
public class Cliente {

	protected Cliente() {}

	@Id @GeneratedValue private Long id;
	
	private Address address;
	
	private String nombre;
	private String apellidos;
	private String dni;
	
	@OneToMany(mappedBy="cliente") private Set<Vehiculo> vehiculos = new HashSet<>();
	
	@OneToMany(mappedBy="cliente", cascade = {CascadeType.PERSIST}) private Set<MedioPago> mediosPago = new HashSet<>();

	public Cliente(String dni) {
		super();
		this.dni = dni;
	}

	public Cliente(String dni, String nombre, String apellidos) {
		this(dni);
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	Set<Vehiculo> _getVehiculos() {
		return vehiculos;
	}

	public Set<Vehiculo> getVehiculos() {
		return new HashSet<>(vehiculos);
	}

	Set<MedioPago> _getMediosPago() {
		return mediosPago;
	}

    public Set<MedioPago> getMediosPago() {
        return new HashSet<>(mediosPago);
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Long getId() {
		return id;
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
		Cliente other = (Cliente) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", address=" + address + "]";
	}

}
