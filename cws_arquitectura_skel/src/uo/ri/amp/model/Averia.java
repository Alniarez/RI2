package uo.ri.amp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import uo.ri.amp.model.types.AveriaStatus;


@Entity @Table(name = "TAVERIAS") 
public class Averia {
	
	Averia(){}

	@Id	@GeneratedValue private Long id;
		
	private String descripcion;
	@Transient  private static final String DESCRIPCION_VACIA = "sin descrpicion";
	
	@Temporal(TemporalType.DATE) private Date fecha;
	
	private double importe = 0.0;
	
	@Enumerated(EnumType.STRING) private AveriaStatus status = AveriaStatus.ABIERTA;
	
	@JoinColumn(name = "FACTURA_ID")  @ManyToOne private Factura factura;
	@JoinColumn(name = "MECANICO_ID") @ManyToOne private Mecanico mecanico;
	@JoinColumn(name = "VEHICULO_ID") @ManyToOne private Vehiculo vehiculo;

	@OneToMany(mappedBy="averia")
	private Set<Intervencion> intervenciones = new HashSet<Intervencion>();
	
	public Averia(Vehiculo vehiculo)
	{
		this(new Date(),DESCRIPCION_VACIA, vehiculo);
	}
	
	public Averia(Date fecha,String descripcion, Vehiculo vehiculo) {
		this.fecha = fecha;
		this.descripcion=descripcion;
		Association.Averiar.link(vehiculo,this);
	}
	public Averia(Date fecha,String descripcion, Vehiculo vehiculo, AveriaStatus status) {
		this.fecha = fecha;
		this.descripcion=descripcion;
		this.status = status;
		Association.Averiar.link(vehiculo,this);
	}
	

	public Averia(Vehiculo vehiculo, String descripcion) {
		this(new Date(), descripcion,vehiculo);
		
	}

	public void calcularImporte(){
		
		double importeAcumulado=0.0;
		for(Intervencion v : intervenciones)
			importeAcumulado+= v.getImporte();
		
		importe = importeAcumulado;
	}
	

	public Factura getFactura() {
		return factura;
	}

	void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Set<Intervencion> getIntervenciones() {
		return intervenciones;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public Date getFecha() {
		return fecha;
	}

	public double getImporte() {
		calcularImporte();
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public AveriaStatus getStatus() {
		return status;
	}

	public void setStatus(AveriaStatus status) {
		this.status = status;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((vehiculo == null) ? 0 : vehiculo.hashCode());
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
		Averia other = (Averia) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (vehiculo == null) {
			if (other.vehiculo != null)
				return false;
		} else if (!vehiculo.equals(other.vehiculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Averia [descripcion=" + descripcion + ", fecha=" + fecha + ", importe=" + importe + ", status=" + status
				+ ", vehiculo=" + vehiculo + "]";
	}

	public long getId() {
		
		return id;
	}
}
