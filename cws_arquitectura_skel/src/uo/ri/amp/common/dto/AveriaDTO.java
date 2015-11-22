package uo.ri.amp.common.dto;

import java.util.Date;

/**
 * Created by Jorge.
 */
public class AveriaDTO {

    private String matricula;
    private String descripcion;
    private Date fechaEntrada;
    private long idMecanico;

    public static AveriaDTO create() {
        return new AveriaDTO();
    }

    public String getMatricula() {
        return matricula;
    }

    public AveriaDTO setMatricula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public AveriaDTO setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public AveriaDTO setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
        return this;
    }

    public AveriaDTO setIdMecanico(long idMecanico) {
        this.idMecanico = idMecanico;
        return this;
    }

    public long getIdMecanico() {
        return idMecanico;
    }
}
