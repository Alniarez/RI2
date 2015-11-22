package uo.ri.amp.business.impl.command.foreman.breakdown;

import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AveriaDTO;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.*;
import uo.ri.amp.persistence.model.types.AveriaStatus;

/**
 * Created by Jorge.
 */
public class AssignBreakdown implements Command {

	private final AveriaDTO dto;
    private Mecanico mecanico;
    private Averia averia;

    public AssignBreakdown(AveriaDTO averia) {
		this.dto = averia;
	}

	@Override
	public Object execute() throws BusinessException {
		comprobar();

        Association.Asignar.link(mecanico,averia);

		return null;
	}

    private void comprobar() throws BusinessException {
        Vehiculo vehiculo = Finder.vehiculo.findByMatricula(dto.getMatricula());
        if(vehiculo==null)
            throw new BusinessException("No existe el vehículo.");

        TipoVehiculo tipoVehiculo = vehiculo.getTipo();
        mecanico = Finder.experto.findbyIdMecanico_Tipo(dto.getIdMecanico(),
                tipoVehiculo.getId());
        if(mecanico == null)
            throw new BusinessException(
                    "No se puede asignar la averia a este mecánico.");

        averia = Finder.averia.findOne(dto);
        if(averia == null)
            throw new BusinessException("La avería no existe.");
        if(!(averia.getStatus().equals(AveriaStatus.ABIERTA)))
            throw new BusinessException("La avería ya está asignada.");
    }

}