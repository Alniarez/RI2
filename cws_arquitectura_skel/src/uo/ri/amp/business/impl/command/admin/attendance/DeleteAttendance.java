package uo.ri.amp.business.impl.command.admin.attendance;

import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AsistenciaDTO;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.Asistencia;
import uo.ri.amp.persistence.model.Association;
import uo.ri.amp.persistence.model.Curso;
import uo.ri.amp.persistence.model.Mecanico;
import uo.ri.amp.persistence.util.Jpa;

/**
 * Created by Jorge.
 */
public class DeleteAttendance implements Command {

    private final String codigoCurso;
    private final Long idMecanico;
    private Asistencia asistencia;

    public DeleteAttendance(AsistenciaDTO asistenciaDTO) {
        this.codigoCurso = asistenciaDTO.getCurso().getCodigo();
        this.idMecanico = asistenciaDTO.getMecanico().getId();
    }

    @Override
    public Object execute() throws BusinessException {
        comprobar();

        Jpa.getManager().remove(asistencia);
        Association.Asistir.unlink(asistencia);

        return null;
    }

    private void comprobar() throws BusinessException {
        //Existe curso
        Curso curso = Finder.curso.findByCodigo(codigoCurso);
        if (curso == null)
            throw new BusinessException("No existe el curso.");
        //Existe mecanido
        Mecanico mecanico = Finder.mecanico.findById(idMecanico);
        if (mecanico == null)
            throw new BusinessException("No existe el mecánico.");
        //Existe asistencia
        asistencia = Finder.asistencia.findOne(codigoCurso, idMecanico);
        if (asistencia == null)
            throw new BusinessException("No existe la asistencia.");
    }
}
