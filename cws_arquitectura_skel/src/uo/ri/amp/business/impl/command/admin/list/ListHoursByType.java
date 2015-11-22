package uo.ri.amp.business.impl.command.admin.list;

import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.HorasMecanicoTipoDTO;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.Mecanico;
import uo.ri.amp.persistence.model.TipoVehiculo;

import java.util.List;

/**
 * Created by Jorge.
 */
public class ListHoursByType implements Command {

	@Override
	public Object execute() throws BusinessException {
		List<HorasMecanicoTipoDTO> horas = Finder.asistencia.findHoursByType();
        StringBuilder sb = new StringBuilder();
		String tipo = "";
		for (HorasMecanicoTipoDTO dto : horas) {
			Mecanico mecanico = Finder.mecanico.findById(dto.getIdMecanico());
			TipoVehiculo tipoVehiculo = Finder.tipoVehiculo.findById(dto.getIdTipo());
			if (!tipo.equalsIgnoreCase(tipoVehiculo.getNombre())){
				tipo = tipoVehiculo.getNombre();
				sb.append(tipo);
				sb.append("\n");
			}
			sb.append("\t");
			sb.append(mecanico.getNombre());
			sb.append(" ");
			sb.append(mecanico.getApellidos());
			sb.append(" ");
			sb.append(dto.getHoras());
			sb.append(" horas");
			sb.append("\n");
		}
        return sb.toString();
	}

}
