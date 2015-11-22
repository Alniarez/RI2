package uo.ri.amp.common.dto;

/**
 * Created by Jorge.
 */
public class HorasAsistenciaDTO {

    private long horasTotales;
    private long horasCursadas;

    public static HorasAsistenciaDTO create(){
        return new HorasAsistenciaDTO();
    }

    public long getHorasTotales() {
        return horasTotales;
    }

    public HorasAsistenciaDTO setHorasTotales(long horasTotales) {
        this.horasTotales = horasTotales;
        return this;
    }

    public long getHorasCursadas() {
        return horasCursadas;
    }

    public HorasAsistenciaDTO setHorasCursadas(long horasCursadas) {
        this.horasCursadas = horasCursadas;
        return this;
    }
}
