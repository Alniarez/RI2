package uo.ri.amp.common.dto;

/**
 * Created by Jorge.
 */
public class HorasMecanicoTipoDTO {

    private long idTipo;
    private long idMecanico;
    private long horas;

    public static HorasMecanicoTipoDTO create(){
        return new HorasMecanicoTipoDTO();
    }

    public long getIdTipo() {
        return idTipo;
    }

    public HorasMecanicoTipoDTO setIdTipo(long idTipo) {
        this.idTipo = idTipo;
        return this;
    }

    public long getIdMecanico() {
        return idMecanico;
    }

    public HorasMecanicoTipoDTO setIdMecanico(long idMecanico) {
        this.idMecanico = idMecanico;
        return this;
    }

    public long getHoras() {
        return horas;
    }

    public HorasMecanicoTipoDTO setHoras(long horas) {
        this.horas = horas;
        return this;
    }
}
