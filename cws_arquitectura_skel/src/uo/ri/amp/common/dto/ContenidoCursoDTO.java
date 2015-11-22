package uo.ri.amp.common.dto;

/**
 * Created by Jorge.
 */
public class ContenidoCursoDTO {

    private long id;
    private long cursoId;
    private long tipoVehiculoId;
    private int porcentaje;

    public static ContenidoCursoDTO create(){
        return new ContenidoCursoDTO();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCursoId() {
        return cursoId;
    }

    public void setCursoId(long cursoId) {
        this.cursoId = cursoId;
    }

    public long getTipoVehiculoId() {
        return tipoVehiculoId;
    }

    public void setTipoVehiculoId(long tipoVehiculoId) {
        this.tipoVehiculoId = tipoVehiculoId;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
