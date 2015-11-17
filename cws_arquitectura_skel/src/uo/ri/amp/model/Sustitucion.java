package uo.ri.amp.model;

import javax.persistence.*;

import uo.ri.amp.model.key.SustitucionKey;

@Entity
@IdClass( SustitucionKey.class )
@Table(name = "TSUSTITUCIONES")
public class Sustitucion {
	
	Sustitucion() {}
	
	private int cantidad;
	
	@Id @ManyToOne @JoinColumn(name = "REPUESTO_ID") private Repuesto repuesto;
	@Id @ManyToOne private Intervencion intervencion;
	

	public Sustitucion(Repuesto repuesto, Intervencion intervencion) {
		Association.Sustituir.link(repuesto,this,intervencion);
	}

	public double getImporte(){
		return (float) repuesto.getPrecio()*cantidad;
	}

	public Repuesto getRepuesto() {
		return repuesto;
	}


	void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}


	public Intervencion getIntervencion() {
		return intervencion;
	}


	void setIntervencion(Intervencion intervencion) {
		this.intervencion = intervencion;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
