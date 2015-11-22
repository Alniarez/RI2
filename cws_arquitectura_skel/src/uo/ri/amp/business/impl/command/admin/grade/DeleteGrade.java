package uo.ri.amp.business.impl.command.admin.grade;


import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.CursoDTO;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.ContenidoCurso;
import uo.ri.amp.persistence.model.Curso;
import uo.ri.amp.persistence.util.Jpa;

/**
 * Created by Jorge.
 */
public class DeleteGrade implements Command {

	private final String codigo;

	public DeleteGrade(CursoDTO curso) {
		this.codigo=curso.getCodigo();
	}

	@Override
	public Object execute() throws BusinessException {
		Curso curso = Finder.curso.findByCodigo(codigo);

        if(curso==null)
            throw new BusinessException("No existe el curso.");

        if(curso.getAsistencias().size()!=0)
            throw new BusinessException("No puede elimiar el curso si tiene asistencias.");

        for(ContenidoCurso cc : curso.getContenidoCurso())
            Jpa.getManager().remove(cc);

        Jpa.getManager().remove(curso);

        return null;
	}

}
