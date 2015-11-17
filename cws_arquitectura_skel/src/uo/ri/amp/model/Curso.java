package uo.ri.amp.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TCURSOS")
public class Curso {

	@Id @GeneratedValue private Long id;
	
	private String codigo;
	private String nombre;
	private String descripcion;
	private int nHoras;
	
	@OneToMany(mappedBy="curso") private Set<ContenidoCurso> contenidoCurso = new HashSet<ContenidoCurso>();
	@OneToMany(mappedBy="curso") private Set<Asistencia> asistencias = new HashSet<Asistencia>();
	
	Curso(){}
	
	public Curso(String codigo) {
		
		this.codigo = codigo;
	}
	
	public Curso(String codigo, String nombre, String descripcion, int nHoras,List<TipoVehiculo> vehiculos,List<Integer> pHoras){
		this.codigo = codigo;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.nHoras=nHoras;
		for(int i=0;i<vehiculos.size();i++)
			new ContenidoCurso(this,vehiculos.get(i),pHoras.get(i));
	}

	
	
	public Set<Asistencia> getAsistencias() {
		return asistencias;
	}



	public Set<ContenidoCurso> getContenidoCurso() {
		return contenidoCurso;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getnHoras() {
		return nHoras;
	}


	public void setnHoras(int nHoras) {
		this.nHoras = nHoras;
	}


	public String getCodigo() {
		return codigo;
	}


	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Curso other = (Curso) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", nHoras=" + nHoras
				+ "]";
	}
	
	
	
	
}
