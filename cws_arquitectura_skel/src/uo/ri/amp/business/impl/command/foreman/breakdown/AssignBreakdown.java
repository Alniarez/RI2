package uo.ri.amp.business.impl.command.foreman.breakdown;

import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AveriaDTO;

/**
 * Created by Jorge.
 */
public class AssignBreakdown implements Command {

	private final AveriaDTO dto;

	public AssignBreakdown(AveriaDTO averia) {
		this.dto = averia;
	}

	@Override
	public Object execute() throws BusinessException {
		comprobar();
            //TODO
		return null;
	}

    private void comprobar() {

    }

}