package uo.ri.amp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Inheritance
@Table(name = "TMEDIOSPAGO")
@DiscriminatorColumn(
		name = "DTYPE",
		discriminatorType = DiscriminatorType.STRING
)
public abstract class MedioPago {
	
	MedioPago(){}
	
	@Id @GeneratedValue private Long id;
	
	protected double acumulado = 0.0;
	
	@ManyToOne protected Cliente cliente;

	@OneToMany(mappedBy="medioPago") private Set<Cargo> cargos = new HashSet<Cargo>();
	
	public MedioPago(double acumulado) {
		
		this.acumulado = acumulado;
	}
	public MedioPago(Cliente cliente) {
			Association.Pagar.link(cliente, this);
	}

	public Set<Cargo> getCargos() {
		return cargos;
	}

	public void setAcumulado(double acumulado) {
		this.acumulado = acumulado;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public double getAcumulado() {
		return acumulado;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
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
		MedioPago other = (MedioPago) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MedioPago [acumulado=" + acumulado + ", cliente=" + cliente + "]";
	}
	
	public String toFormatedString() {
		return this.toString();
	}
	public long getId() {
		
		return id;
	}
}
