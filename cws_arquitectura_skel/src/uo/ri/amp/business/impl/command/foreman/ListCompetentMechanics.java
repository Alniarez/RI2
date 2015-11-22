package uo.ri.amp.business.impl.command.foreman;

import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.VehiculoDTO;
import uo.ri.amp.common.util.TableBuilder;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.Experto;
import uo.ri.amp.persistence.model.TipoVehiculo;
import uo.ri.amp.persistence.model.Vehiculo;

import java.util.List;

/**
 * Created by Jorge.
 */
public class ListCompetentMechanics  implements Command {

    private VehiculoDTO vehiculoDTO;
    private List<Experto> expertos;

	public ListCompetentMechanics(VehiculoDTO vehiculo) {
		this.vehiculoDTO = vehiculo;
	}

	@Override
	public Object execute() throws BusinessException {
		comprobar();

        TableBuilder tb = new TableBuilder();
        tb.addRow("Experto", "Id");
        tb.addRow("-----", "-----");
        for(Experto e : expertos)
            tb.addRow(e.getMecanico().getNombre()+" "+e.getMecanico().getApellidos(),
                    e.getMecanico().getId()+"");

		return tb;
	}

    private void comprobar() throws BusinessException{
        Vehiculo vehiculo = Finder.vehiculo.findByMatricula(vehiculoDTO.getMatricula());
        if(vehiculo == null)
            throw new BusinessException("No existe el vehículo");
        TipoVehiculo tipoVehiculo = vehiculo.getTipo();
        expertos = Finder.experto.findByTipo(tipoVehiculo);
        if(expertos==null)
            throw new BusinessException("No hay mecánicos expertos en ese tipo de vehículo.");
    }

}