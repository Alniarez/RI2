package uo.ri.amp.business.impl;

import uo.ri.amp.business.ForemanService;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.util.TableBuilder;

/**
 * Created by Jorge on 17/11/2015.
 */
public class ForemanServiceImpl implements ForemanService{

    @Override
    public void addBreakdown(Averia averia) throws BusinessException {

    }

    @Override
    public void updateBreakdown(Averia averia) throws BusinessException {

    }

    @Override
    public void assignBreakdown(Averia averia) throws BusinessException {

    }

    @Override
    public void removeBreakdown(Long idAveria) throws BusinessException {

    }

    @Override
    public TableBuilder listCompetentMechanics(Vehiculo vehiculo) throws BusinessException {
        return null;
    }

    @Override
    public TableBuilder listBreakdownHistory(Vehiculo vehiculo) throws BusinessException {
        return null;
    }
}
