package uo.ri.amp.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "TVEHICULOS")
public class Vehiculo {
	
	Vehiculo(){}
	
	@Id @GeneratedValue private Long id;
	
	private String marca;
	private String matricula;
	private String modelo;
	
	@Column(name="NUM_AVERIAS")
	private int numAverias = 0;

	@ManyToOne @JoinColumn(name = "CLIENTE_ID") private Cliente cliente;
	@ManyToOne @JoinColumn(name = "TIPO_ID") private TipoVehiculo tipo;
	
	@OneToMany(mappedBy="vehiculo") private Set<Averia> averias = new HashSet<Averia>();
	
	public Vehiculo(String matricula) {
		
		this.matricula = matricula;
		
	}
	
	public Vehiculo(String matricula, String marca, String modelo) {
		this(matricula);
		this.marca = marca;
		this.modelo = modelo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoVehiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVehiculo tipo) {
		this.tipo = tipo;
	}

	public Set<Averia> getAverias() {
		return averias;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Long getId() {
		return id;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getNumAverias() {
		return numAverias;
	}

	public void setNumAverias(int numAverias) {
		this.numAverias = numAverias;
	}

	public String getMatricula() {
		return matricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Vehiculo other = (Vehiculo) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", matricula=" + matricula + ", modelo=" + modelo + ", numAverias="
				+ numAverias + "]";
	}



	public void removeAveria(Averia averia) {
		Association.Averiar.unlink(this, averia);
		
	}
	
	
	
}
