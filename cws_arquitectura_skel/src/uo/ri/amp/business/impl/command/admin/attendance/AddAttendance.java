package uo.ri.amp.business.impl.command.admin.attendance;


import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AsistenciaDTO;
import uo.ri.amp.persistence.model.Asistencia;
import uo.ri.amp.persistence.model.Curso;
import uo.ri.amp.persistence.model.Mecanico;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.util.Jpa;

/**
 * Created by Jorge.
 */
public class AddAttendance implements Command {

    private final AsistenciaDTO dto;
    private Asistencia asistencia;
    private Mecanico mecanico;
    private Curso curso;

    public AddAttendance(AsistenciaDTO asistencia) {
		this.dto = asistencia;
	}

	@Override
	public Object execute() throws BusinessException {

        comprobar();

        asistencia = new Asistencia(curso, mecanico, dto.getFechaIn(), dto.getFechaOut(), dto.getPorcentaje(), dto.getApto());

        Jpa.getManager().persist(asistencia);

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

        //No existe la asistencia
        asistencia = Finder.asistencia.findOne(dto.getCurso().getCodigo(),dto.getMecanico().getId());
        if(asistencia != null)
            throw new BusinessException("La asistencia ya existe. Utilice el menú adecuado para modificarla.");

        //Apto correcto
        if(dto.getPorcentaje() < 85 && dto.getApto().equals("APTO"))
            throw new BusinessException("Debe tener una asistencia de de 85% para ser apto.");

        //Fechas bien
        if(!(dto.getFechaIn().before(dto.getFechaOut())))
            throw new BusinessException("La fecha de finalización no puede ser anterior a la de inicio.");
    }
}
