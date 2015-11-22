package uo.ri.amp.business.impl.command.foreman.breakdown;

import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AveriaDTO;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.Averia;
import uo.ri.amp.persistence.model.Vehiculo;
import uo.ri.amp.persistence.util.Jpa;

/**
 * Created by Jorge.
 */
public class RemoveBreakdown implements Command {

	private final AveriaDTO dto;
    private Averia averia;
    private Vehiculo vehiculo;

	public RemoveBreakdown(AveriaDTO averia) {
		this.dto = averia;
	}

	@Override
	public Object execute() throws BusinessException {
		comprobar();

        Jpa.getManager().remove(averia);
		vehiculo.removeAveria(averia);

		return null;
	}

    private void comprobar() throws BusinessException {
        averia = Finder.averia.findOne(dto);
        if(averia == null)
            throw new BusinessException("No existe la avería");
        vehiculo = averia.getVehiculo();
    }

}