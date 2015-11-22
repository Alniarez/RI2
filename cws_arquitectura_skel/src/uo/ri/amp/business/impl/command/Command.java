package uo.ri.amp.business.impl.command;

import uo.ri.amp.common.BusinessException;

public interface Command {
	
	Object execute() throws BusinessException;

}