package uo.ri.amp.common.dto;

/**
 * Created by Jorge.
 */
public class MecanicoDTO {

    private long id;

    public static MecanicoDTO create(){
        return new MecanicoDTO();
    }

    public long getId() {
        return id;
    }

    public MecanicoDTO setId(long id) {
        this.id = id;
        return this;
    }
}
