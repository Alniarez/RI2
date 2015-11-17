package uo.ri.amp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import alb.util.date.DateUtil;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.model.types.AveriaStatus;
import uo.ri.amp.model.types.FacturaStatus;

@Entity
@Table(name = "TFACTURAS")
public class Factura {
	
	Factura(){}
	
	@Id @GeneratedValue private Long id;
	
	@Temporal(TemporalType.DATE) private Date fecha;

	private double importe;
	private double iva;
	private Long numero;
	
	@Enumerated(EnumType.STRING) private FacturaStatus status = FacturaStatus.SIN_ABONAR;
		
	@OneToMany(mappedBy="factura") private Set<Averia> averias = new HashSet<Averia>();
	@OneToMany(mappedBy="factura") private Set<Cargo> cargos = new HashSet<Cargo>();
	
	public Factura(Long numero) {
		this(numero, new Date());
	}
	public Factura(long numero, Date fecha) {
		this.numero=numero;
		this.fecha=fecha;
	}
	
	
	
	public Factura(long numero, List<Averia> averias) throws BusinessException {
		this(numero);
		for(Averia a : averias)
			addAveria(a);
			
	}
	public Factura(long numero, Date fecha, List<Averia> averias) throws BusinessException {
		this(numero,fecha);
		for(Averia a : averias)
			addAveria(a);
	}
	
	
	public void calcularImporte()
	{
		double importeAcumulado=0.0;
		for(Averia a : averias)
			importeAcumulado+=a.getImporte();
		
		if(fecha.before(_1_7_2012))
			importeAcumulado+=(importeAcumulado*IVAMIN);
		else
			importeAcumulado+=(importeAcumulado*IVAMAX);
		importe = Math.rint(importeAcumulado*100)/100;
	}
	public Set<Cargo> getCargos() {
		return cargos;
	}
	public Set<Averia> getAsignadas() {
		return averias;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getImporte() {
		calcularImporte();
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	public Set<Averia> getAverias() {
		return averias;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public FacturaStatus getStatus() {
		return status;
	}
	public void setStatus(FacturaStatus status) {
		this.status = status;
	}
	public Long getNumero() {
		return numero;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Factura other = (Factura) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", fecha=" + fecha + ", importe=" + importe + ", iva=" + iva + ", status="
				+ status + "]";
	}
	public void addAveria(Averia averia) throws BusinessException {
		if(averia.getStatus()!=AveriaStatus.TERMINADA)
			throw new BusinessException("La avería ha de encontrarse como terminada para poder facturar");
		Association.Facturar.link(this,averia);
		
	}
	public void removeAveria(Averia averia) {
		Association.Facturar.unlink(this,averia);
		
	}

	@Transient private static final Date _1_7_2012 = DateUtil.fromString("1/7/2012");
	@Transient private static final double IVAMIN = 0.18;
	@Transient private static final double IVAMAX = 0.21;

	public long getId() {
		
		return id;
	}

	
}
