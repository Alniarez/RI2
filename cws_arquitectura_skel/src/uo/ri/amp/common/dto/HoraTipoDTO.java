package uo.ri.amp.common.dto;

/**
 * Created by Jorge.
 */
public class HoraTipoDTO {

    private Long horas;
    private Long idTipo;

    public static HoraTipoDTO create(){
        return new HoraTipoDTO();
    }

    public Long getHoras() {
        return horas;
    }

    public HoraTipoDTO setHoras(Long horas) {
        this.horas = horas;
        return this;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public HoraTipoDTO setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
        return this;
    }
}
