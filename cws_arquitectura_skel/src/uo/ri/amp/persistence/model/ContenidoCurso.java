
package uo.ri.amp.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import uo.ri.amp.persistence.model.key.ContenidoCursoKey;

@Entity
@IdClass(ContenidoCursoKey.class)
@Table(name = "TCONTENIDOCURSO")
public class ContenidoCurso {

	private int porcentaje;

	@Id
	@ManyToOne
	@JoinColumn(name = "CURSO_ID")
	private Curso curso;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "TIPOVEHICULO_ID")
	private TipoVehiculo tipoVehiculo;

	protected ContenidoCurso() {
	}

	public ContenidoCurso(int porcentaje){
		this.porcentaje=porcentaje;
	}

	public ContenidoCurso(Curso curso, TipoVehiculo tipoVehiculo) {
		Association.Contiene.link(curso, this, tipoVehiculo);
	}

	public ContenidoCurso(Curso curso, TipoVehiculo tipoVehiculo, int phorasCurso) {
		this.porcentaje = phorasCurso;
		Association.Contiene.link(curso, this, tipoVehiculo);
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Curso getCurso() {
		return curso;
	}

	void setCurso(Curso curso) {
		this.curso = curso;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
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
		ContenidoCurso other = (ContenidoCurso) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
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
		return "ContenidoCurso [porfentaje=" + porcentaje + ", curso=" + curso + ", tipoVehiculo=" + tipoVehiculo + "]";
	}


}