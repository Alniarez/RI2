package uo.ri.amp.common.dto;

import java.util.Date;

/**
 * Created by Jorge.
 */
public class ExpertoDTO {

    private long idTipoVehiculo;
    private long idMecanico;
    private Date date;

    public static ExpertoDTO create(){
        return new ExpertoDTO();
    }

    public long getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public ExpertoDTO setIdTipoVehiculo(long idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
        return this;
    }

    public long getIdMecanico() {
        return idMecanico;
    }

    public ExpertoDTO setIdMecanico(long idMecanico) {
        this.idMecanico = idMecanico;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public ExpertoDTO setDate(Date date) {
        this.date = date;
        return this;
    }
}
