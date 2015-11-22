package uo.ri.amp.common.dto;

/**
 * Created by Jorge.
 */
public class VehiculoDTO {

    private String matricula;

    public static VehiculoDTO create(){
        return new VehiculoDTO();
    }

    public String getMatricula() {
        return matricula;
    }

    public VehiculoDTO setMatricula(String matricula) {
        this.matricula = matricula;
        return this;
    }
}
