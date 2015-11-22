package uo.ri.amp.business.impl.command.foreman.breakdown;

import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AveriaDTO;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.Averia;
import uo.ri.amp.persistence.model.Vehiculo;
import uo.ri.amp.persistence.util.Jpa;

import java.util.Date;

/**
 * Created by Jorge.
 */
public class AddBreakdown implements Command {

	private final AveriaDTO dto;
    private Averia averia;
    private Vehiculo vehiculo;

	public AddBreakdown(AveriaDTO averia) {
		this.dto = averia;
	}

	@Override
	public Object execute() throws BusinessException {
        comprobar();
        Jpa.getManager().persist(
                new Averia(dto.getFechaEntrada(),dto.getDescripcion(),vehiculo));
		return null;
	}

    private void comprobar() throws BusinessException {
        vehiculo = Finder.vehiculo.findByMatricula(dto.getMatricula());
        if(vehiculo==null)
            throw new BusinessException("No existe el vehículo.");
        averia = Finder.averia.findOne(dto);
        if(averia != null)
            throw new BusinessException("La averia que quiere crear ya existe.");
    }

}