package uo.ri.amp.common.dto;

import java.util.Date;

/**
 * Created by Jorge.
 */
public class AsistenciaDTO {

    private CursoDTO curso;
    private MecanicoDTO mecanico;
    private int porcentaje;
    private Date fechaIn;
    private Date fechaOut;
    private String apto;

    public static AsistenciaDTO create(){
        return new AsistenciaDTO();
    }

    public CursoDTO getCurso() {
        return curso;
    }

    public AsistenciaDTO setCurso(CursoDTO curso) {
        this.curso = curso;
        return this;
    }

    public MecanicoDTO getMecanico() {
        return mecanico;
    }

    public AsistenciaDTO setMecanico(MecanicoDTO mecanico) {
        this.mecanico = mecanico;
        return this;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public AsistenciaDTO setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
        return this;
    }

    public Date getFechaIn() {
        return fechaIn;
    }

    public AsistenciaDTO setFechaIn(Date fechaIn) {
        this.fechaIn = fechaIn;
        return this;
    }

    public Date getFechaOut() {
        return fechaOut;
    }

    public AsistenciaDTO setFechaOut(Date fechaOut) {
        this.fechaOut = fechaOut;
        return this;
    }

    public String getApto() {
        return apto;
    }

    public AsistenciaDTO setApto(String apto) {
        this.apto = apto;
        return this;
    }

    public AsistenciaDTO setApto(boolean apto) {
        return setApto((apto) ? "APTO" : "NO_APTO");
    }
}
