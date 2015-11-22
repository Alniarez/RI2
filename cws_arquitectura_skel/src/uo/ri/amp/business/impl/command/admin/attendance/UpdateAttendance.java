package uo.ri.amp.business.impl.command.admin.attendance;


import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AsistenciaDTO;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.Asistencia;
import uo.ri.amp.persistence.model.Curso;
import uo.ri.amp.persistence.model.Mecanico;
import uo.ri.amp.persistence.util.Jpa;

/**
 * Created by Jorge.
 */
public class UpdateAttendance  implements Command {

	private final AsistenciaDTO dto;
    private Mecanico mecanico;
    private Curso curso;
    private Asistencia asistencia;

	public UpdateAttendance(AsistenciaDTO asistencia) {
		this.dto = asistencia;
	}

	@Override
	public Object execute() throws BusinessException {

        comprobar();

        asistencia.setApto(dto.getApto());
        asistencia.setFechaFin(dto.getFechaOut());
        asistencia.setFechaInicio(dto.getFechaIn());
        asistencia.setpAsistencia(dto.getPorcentaje());

        asistencia = Jpa.getManager().merge(asistencia);

		return null;
	}

    private void comprobar() throws BusinessException {
        //Existe el mecanico
        mecanico = Finder.mecanico.findById(dto.getMecanico().getId());
        if(mecanico == null)
            throw new BusinessException("No existe el mecánico.");

        //Existe el curso
        curso = Finder.curso.findByCodigo(dto.getCurso().getCodigo());
        if(curso == null)
            throw new BusinessException("No existe el curso.");

        //Existe la asistencia
        asistencia = Finder.asistencia.findOne(dto.getCurso().getCodigo(),dto.getMecanico().getId());
        if(asistencia == null)
            throw new BusinessException("La asistencia no existe. Utilice el menú adecuado para crearla.");

        //Apto correcto
        if(dto.getPorcentaje() <= 85 && dto.getApto().equals("APTO"))
            throw new BusinessException("Debe tener una asistencia de de 85% para ser apto.");

        //Fechas bien
        if(dto.getFechaIn().before(dto.getFechaOut()))
            throw new BusinessException("La fecha de finalización no puede ser posterior a la de inicio.");

    }

}
