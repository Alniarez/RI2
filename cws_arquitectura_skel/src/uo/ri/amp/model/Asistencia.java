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

import uo.ri.amp.model.key.AsistenciaKey;

@Entity
@IdClass(AsistenciaKey.class)
@Table(name = "TASISTENCIAS")
public class Asistencia {

	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	private int porcentaje;
	private String apto;

	@Id
	@ManyToOne
	@JoinColumn(name = "CURSO_ID")
	private Curso curso;
	@Id
	@ManyToOne
	@JoinColumn(name = "MECANICO_ID")
	private Mecanico mecanico;

	Asistencia() {
	}

	public Asistencia(Curso curso, Mecanico mecanico, Date fechaInicio, Date fechaFin, int porentaje, String apto) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.porcentaje = porentaje;
		this.apto = apto;
		addAsistencia(curso, mecanico);
	}

	public Asistencia(Curso curso, Mecanico mecanico) {
		addAsistencia(curso, mecanico);
	}

	public void addAsistencia(Curso curso, Mecanico mecanico) {
		Association.Asistir.link(curso, this, mecanico);
	}

	public void removeAsistencia(Curso curso, Mecanico mecanico) {
		Association.Asistir.unlink(this);
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getpAsistencia() {
		return porcentaje;
	}

	public void setpAsistencia(int pAsistencia) {
		this.porcentaje = pAsistencia;
	}

	public String getApto() {
		return apto;
	}

	public void setApto(String apto) {
		this.apto = apto;
	}

	public Curso getCurso() {
		return curso;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	void setCurso(Curso curso) {
		this.curso = curso;
	}

	void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
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
		Asistencia other = (Asistencia) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
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
		return "Asistencia [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", porcentaje=" + porcentaje
				+ ", apto=" + apto + ", curso=" + curso + ", mecanico=" + mecanico + "]";
	}

}
