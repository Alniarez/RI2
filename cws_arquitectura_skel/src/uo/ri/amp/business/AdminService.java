package uo.ri.amp.business;

import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AsistenciaDTO;
import uo.ri.amp.common.dto.CursoDTO;
import uo.ri.amp.common.dto.MecanicoDTO;
import uo.ri.amp.common.util.TableBuilder;

public interface AdminService {
	
	/**
	 * Añade un curso a la base de datos.
	 * @param curso
	 * @throws BusinessException
	 */
    void addGrade(CursoDTO curso) throws BusinessException;

    /**
     * Borra un curso de la base de datos.
     * Es necesario que no haya asistencias.
     * @param curso
     * @throws BusinessException
     */
    void deleteGrade(CursoDTO curso) throws BusinessException;

    /**
     * Actualiza los datos y los contenidos de un curso.
     * @param curso
     * @throws BusinessException
     */
    void updateGrade(CursoDTO curso) throws BusinessException;

    /**
     * Lista todos los cursos.
     * @return
     * @throws BusinessException
     */
    TableBuilder listGrades() throws BusinessException;

    /**
     * Lista todas las asistencias a un curso deterinado.
     * @param asistencia
     * @throws BusinessException
     */
    void addAttendance(AsistenciaDTO asistencia) throws BusinessException;

    /**
     * Borra una asistencia determinada.
     * @param asistenciaDTO
     * @throws BusinessException
     */
	void deleteAttendance(AsistenciaDTO asistenciaDTO) throws BusinessException;

	/**
	 * Modifica los datos de una asistencia.
	 * @param asistencia
	 * @throws BusinessException
	 */
	void updateAttendance(AsistenciaDTO asistencia) throws BusinessException;

	/**
	 * Lista las asistencias a un curso determinado.
	 * @param codigo
	 * @return
	 * @throws BusinessException
	 */
	TableBuilder listAttendance(AsistenciaDTO codigo) throws BusinessException;

	/**
	 * Revisa todas las asistencias y genera certificados de maestría si es necesario.
	 * @return
	 * @throws BusinessException
	 */
	String generateCertificates() throws BusinessException;
	
	/**
	 * Lista las horas de cursos realizadas por todos los mecánicos organizadas por tipos.
	 * @return
	 * @throws BusinessException
	 */
	String listHoursByType() throws BusinessException;

	/**
	 * Lista todas las horas matriculadas y cursadas de un determinado mecánico en todos sus cursos y
	 * la cantidad de horas que ha dedicad a cada tipo de vehículo.
	 * @param mecanico
	 * @return
	 * @throws BusinessException
	 */
	String listHoursByMechanic(MecanicoDTO mecanico) throws BusinessException;

}
