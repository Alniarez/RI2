package uo.ri.amp.business.impl;

import uo.ri.amp.business.ForemanService;
import uo.ri.amp.business.impl.command.CommandExecutor;
import uo.ri.amp.business.impl.command.foreman.ListCompetentMechanics;
import uo.ri.amp.business.impl.command.foreman.breakdown.*;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AveriaDTO;
import uo.ri.amp.common.dto.VehiculoDTO;
import uo.ri.amp.common.util.TableBuilder;

/**
 * Created by Jorge.
 */
public class ForemanServiceImpl implements ForemanService {

    CommandExecutor executor = new CommandExecutor();

    @Override
    public void addBreakdown(AveriaDTO averia) throws BusinessException {
        executor.execute(new AddBreakdown(averia));
    }

    @Override
    public void updateBreakdown(AveriaDTO averia) throws BusinessException {
        executor.execute(new UpdateBreakdown(averia));
    }

    @Override
    public void assignBreakdown(AveriaDTO averia) throws BusinessException {
        executor.execute(new AssignBreakdown(averia));
    }

    @Override
    public void removeBreakdown(AveriaDTO averia) throws BusinessException {
        executor.execute(new RemoveBreakdown(averia));
    }

    @Override
    public TableBuilder listCompetentMechanics(VehiculoDTO vehiculo)
            throws BusinessException {
        return (TableBuilder) executor.execute(new ListCompetentMechanics(vehiculo));
    }

    @Override
    public TableBuilder listBreakdownHistory(VehiculoDTO vehiculo)
            throws BusinessException {
        return (TableBuilder) executor.execute(new ListBreakdownHistory(vehiculo));
    }
}
