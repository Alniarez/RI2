package uo.ri.amp.model;

import javax.persistence.*;

import uo.ri.amp.model.key.CargoKey;

@Entity
@IdClass( CargoKey.class )
@Table(name = "TCARGOS")
public class Cargo {
	
	Cargo(){}
	
	@Id @ManyToOne @JoinColumn(name = "FACTURA_ID") private Factura factura;
	@Id @ManyToOne @JoinColumn(name = "MEDIOPAGO_ID") private MedioPago medioPago;
	@Column(name="IMPORTE") private double importe = 0.0;
		
	public Cargo(Factura factura, MedioPago medioPago) {
		Association.Cargar.link(factura,this,medioPago);
	}

	public Cargo(Factura factura, MedioPago medioPago, double d) {
		this.importe = d;
		Association.Cargar.link(factura,this,medioPago);
	}

	public Factura getFactura() {
		return factura;
	}

	 void setFactura(Factura factura) {
		this.factura = factura;
	}


	public MedioPago getMedioPago() {
		return medioPago;
	}

	 void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
}
