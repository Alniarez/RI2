package uo.ri.amp.business.impl.command.admin.attendance;

import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AsistenciaDTO;
import uo.ri.amp.common.util.TableBuilder;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.Asistencia;

import java.util.List;

/**
 * Created by Jorge.
 */
public class ListAttendance implements Command {

	private final String codigoCurso;

	public ListAttendance(AsistenciaDTO asistenciaDTO) {
		this.codigoCurso = asistenciaDTO.getCurso().getCodigo();
	}

	@Override
	public Object execute() throws BusinessException {
		comprobar();

        List<Asistencia> asistencias;
        asistencias = Finder.asistencia.findByCurso(codigoCurso);

        TableBuilder tb = new TableBuilder();
        tb.addRow("ID Mecnánico", "Fecha de inicio", "Fecha de finalización",
                "t% de asistencia", "Calificación");
        tb.addRow("----------", "----------", "----------",
                "----------", "----------");
        for(Asistencia a : asistencias)
            tb.addRow(
                    a.getMecanico().getId()+"",
                    a.getFechaInicio().toString(),
                    a.getFechaFin().toString(),
                    a.getpAsistencia()+"",
                    a.getApto());
        return tb;
	}

    private void comprobar() throws BusinessException{
        if(Finder.curso.findByCodigo(codigoCurso)==null)
            throw new BusinessException("El curso no existe.");
    }
}
