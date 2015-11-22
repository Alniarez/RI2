package uo.ri.amp.persistence.model.key;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ExpertoKey implements Serializable{

	Long mecanico;
	Long tipoVehiculo;
	
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
		ExpertoKey other = (ExpertoKey) obj;
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
	
	
}
