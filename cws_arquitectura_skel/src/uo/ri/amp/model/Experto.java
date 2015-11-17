package uo.ri.amp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uo.ri.amp.model.key.ExpertoKey;

@Entity
@IdClass( ExpertoKey.class )
@Table(name = "TEXPERTOS")
public class Experto {
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Id @ManyToOne @JoinColumn(name="TIPOVEHICULO_ID")
	private TipoVehiculo tipoVehiculo;
	@Id @ManyToOne @JoinColumn(name="MECANICO_ID")
	private Mecanico mecanico;
	
	Experto(){}
	
	public Experto(TipoVehiculo tipoVehiculo, Mecanico mecanico) {
		Association.Certificar.link(tipoVehiculo,this,mecanico);
		this.tipoVehiculo = tipoVehiculo;
		this.mecanico = mecanico;
	}
	public Experto(Date fecha, TipoVehiculo tipoVehiculo, Mecanico mecanico) {
		
		this.fecha = fecha;
		this.tipoVehiculo = tipoVehiculo;
		this.mecanico = mecanico;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public Mecanico getMecanico() {
		return mecanico;
	}
	void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mecanico == null) ? 0 : mecanico.hashCode());
		result = prime * result + ((tipoVehiculo == null) ? 0 : tipoVehiculo.hashCode());
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
		Experto other = (Experto) obj;
		if (mecanico == null) {
			if (other.mecanico != null)
				return false;
		} else if (!mecanico.equals(other.mecanico))
			return false;
		if (tipoVehiculo == null) {
			if (other.tipoVehiculo != null)
				return false;
		} else if (!tipoVehiculo.equals(other.tipoVehiculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Experto [fecha=" + fecha + ", tipoVehiculo=" + tipoVehiculo + ", mecanico=" + mecanico + "]";
	}
}
