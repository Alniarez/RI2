package uo.ri.amp.business;

import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AveriaDTO;
import uo.ri.amp.common.dto.VehiculoDTO;
import uo.ri.amp.common.util.TableBuilder;

public interface ForemanService {
	
	/**
	 * Crea una avería en la base de datos en estado ABIERTA.
	 * @param averia DTO con los datos necesarios para la creación.
	 * @throws BusinessException En caso de que no se cumpla alguna restricción en el proceso.
	 */
    void addBreakdown(AveriaDTO averia) throws BusinessException;

    /**
     * Modifica la descripción de una avería.
     * @param averia
     * @throws BusinessException En caso de que no se cumpla alguna restricción en el proceso.
     */
    void updateBreakdown(AveriaDTO averia) throws BusinessException;

    /**
     * Asigna una avería a un mecánico.
     * @param averia
     * @throws BusinessException En caso de que no se cumpla alguna restricción en el proceso.
     */
    void assignBreakdown(AveriaDTO averia) throws BusinessException;
    
    /**
     * Elimina una avería de la base de datos si esta no está asignada.
     * @param averia
     * @throws BusinessException En caso de que no se cumpla alguna restricción en el proceso.
     */
    void removeBreakdown(AveriaDTO averia) throws BusinessException;

    /**
     * Lista los mecaicos competentes para repatar cierto tipo de vehículo.
     * @param vehiculo
     * @return 
     * @throws BusinessException En caso de que no se cumpla alguna restricción en el proceso.
     */
    TableBuilder listCompetentMechanics(VehiculoDTO vehiculo) throws BusinessException;

    /**
     * Lista el historial de averias de un determinado vehículo.
     * @param vehiculo
     * @return
     * @throws BusinessException En caso de que no se cumpla alguna restricción en el proceso.
     */
    TableBuilder listBreakdownHistory(VehiculoDTO vehiculo) throws BusinessException;
}
