package uo.ri.amp.business.impl.command.admin.list;

import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.HoraTipoDTO;
import uo.ri.amp.common.dto.HorasAsistenciaDTO;
import uo.ri.amp.common.dto.MecanicoDTO;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.Mecanico;

import java.util.List;

/**
 * Created by Jorge.
 */
public class ListHoursByMechanic implements Command {


    private final MecanicoDTO dto;

    public ListHoursByMechanic(MecanicoDTO mecanico) {
		this.dto = mecanico;
	}

    Mecanico mecanico;
	@Override
	public Object execute() throws BusinessException {

        comprobar();

        HorasAsistenciaDTO horas = Finder.asistencia.findHoursByMechanicA(dto.getId());

        StringBuilder sb = new StringBuilder();
        sb.append("Total de horas de los cursos: ");
        sb.append(horas.getHorasTotales());
        sb.append("\n");
        sb.append("Total de horas asistidas: ");
        sb.append(horas.getHorasCursadas());
        sb.append("\n");

        List<HoraTipoDTO> horasTipo = Finder.asistencia.findHoursByMechanicB(dto.getId());
        for(HoraTipoDTO horaTipo : horasTipo){
            sb.append("Tipo ");
            sb.append(Finder.tipoVehiculo.findById(horaTipo.getIdTipo()).getNombre());
            sb.append(":\t");
            sb.append(horaTipo.getHoras()+" horas\n");
        }

        return sb.toString();
	}

    private void comprobar() throws BusinessException {
        mecanico = Finder.mecanico.findById(dto.getId());
        if(mecanico == null)
            throw new BusinessException("no existe el mecánico.");
    }

}
