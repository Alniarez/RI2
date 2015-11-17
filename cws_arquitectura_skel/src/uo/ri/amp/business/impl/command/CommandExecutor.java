package uo.ri.amp.business.impl.command;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

public class CommandExecutor {
	
	public Object execute(Command command) throws BusinessException {
		EntityManager em = Jpa.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		Object res = null;
		try {
			res = command.execute();
			trx.commit();
		} catch (BusinessException bex) {
			if (trx.isActive())
				trx.rollback();
			throw bex;
		} catch (RuntimeException rex) {
			if (trx.isActive())
				trx.rollback();
			throw rex;
		} finally {
			if (em.isOpen())
				em.close();
		}
		return res;
	}

}
