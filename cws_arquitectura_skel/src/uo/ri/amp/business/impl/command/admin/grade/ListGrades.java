package uo.ri.amp.business.impl.command.admin.grade;


import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.persistence.model.Curso;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.common.util.TableBuilder;

import java.util.List;

/**
 * Created by Jorge.
 */
public class ListGrades implements Command {

	@Override
	public Object execute() throws BusinessException {
        List<Curso> cursos = Finder.curso.findAll();

        TableBuilder tb = new TableBuilder();
        tb.addRow("Código", "Nombre", "Númedo de horas", "Descripción");
        tb.addRow("----", "----", "----", "----");
        for(Curso c : cursos)
            tb.addRow(
                    c.getCodigo(),
                    c.getNombre(),
                    c.getnHoras()+"",
                    c.getDescripcion());
		return tb;
	}

}
