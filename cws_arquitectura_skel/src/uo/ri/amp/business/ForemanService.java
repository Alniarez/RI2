package uo.ri.amp.business;

import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AveriaDTO;
import uo.ri.amp.common.dto.VehiculoDTO;
import uo.ri.amp.persistence.model.Averia;
import uo.ri.amp.persistence.model.Vehiculo;
import uo.ri.amp.common.util.TableBuilder;

public interface ForemanService {
	
    void addBreakdown(AveriaDTO averia) throws BusinessException;

    void updateBreakdown(AveriaDTO averia) throws BusinessException;

    void assignBreakdown(AveriaDTO averia) throws BusinessException;
    
    void removeBreakdown(AveriaDTO averia) throws BusinessException;

    TableBuilder listCompetentMechanics(VehiculoDTO vehiculo) throws BusinessException;

    TableBuilder listBreakdownHistory(VehiculoDTO vehiculo) throws BusinessException;
}
