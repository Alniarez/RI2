package uo.ri.amp.persistence.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import uo.ri.amp.persistence.model.key.IntervencionKey;

@Entity
@IdClass( IntervencionKey.class )
@Table(name = "TINTERVENCIONES")
public class Intervencion {
	
	protected Intervencion(){}
	
	private int minutos;
		
	@Id @ManyToOne @JoinColumn(name = "AVERIA_ID") private Averia averia;
	@Id @ManyToOne @JoinColumn(name = "MECANICO_ID") private Mecanico mecanico;
	
	@OneToMany(mappedBy="intervencion") private Set<Sustitucion> sustituciones = new HashSet<>();

	public Intervencion(Mecanico mecanico, Averia averia) {
		Association.Intervenir.link(mecanico,this,averia);
	}


	public double getImporte()
	{
		
		double importeAcumulado=0;
		for(Sustitucion s : sustituciones)
			importeAcumulado+=s.getImporte();

		importeAcumulado += (averia.getVehiculo().getTipo().getPrecioHora()/60)*minutos;
		return importeAcumulado;
	}
	

	Set<Sustitucion> _getSustituciones() {
		return sustituciones;
	}


	public Set<Sustitucion> getSustituciones() {
		return new HashSet<>(sustituciones);
	}

	public Averia getAveria() {
		return averia;
	}



	 void setAveria(Averia averia) {
		this.averia = averia;
	}



	public Mecanico getMecanico() {
		return mecanico;
	}



	 void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}



	public int getMinutos() {
		return minutos;
	}



	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averia == null) ? 0 : averia.hashCode());
		result = prime * result + ((mecanico == null) ? 0 : mecanico.hashCode());
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
		Intervencion other = (Intervencion) obj;
		if (averia == null) {
			if (other.averia != null)
				return false;
		} else if (!averia.equals(other.averia))
			return false;
		if (mecanico == null) {
			if (other.mecanico != null)
				return false;
		} else if (!mecanico.equals(other.mecanico))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Intervencion [averia=" + averia + ", mecanico=" + mecanico + ", minutos=" + minutos + "]";
	}
	
	
	
}
