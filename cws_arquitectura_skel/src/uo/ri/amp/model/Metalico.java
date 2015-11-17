package uo.ri.amp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "TMetalico")
public class Metalico extends MedioPago {

	Metalico(){}
	
	public Metalico(double acumulado) {
		super(acumulado);
		
	}

	public Metalico(Cliente cliente) {
		super(cliente);
	}

}
