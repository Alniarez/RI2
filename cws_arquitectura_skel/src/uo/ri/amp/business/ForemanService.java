package uo.ri.amp.business;

import uo.ri.amp.common.BusinessException;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.util.TableBuilder;

public interface ForemanService {
	
    void addBreakdown(Averia averia) throws BusinessException;

    void updateBreakdown(Averia averia) throws BusinessException;

    void assignBreakdown(Averia averia) throws BusinessException;
    
    void removeBreakdown(Long idAveria) throws BusinessException;

    TableBuilder listCompetentMechanics(Vehiculo vehiculo) throws BusinessException;

    TableBuilder listBreakdownHistory(Vehiculo vehiculo) throws BusinessException;
}
