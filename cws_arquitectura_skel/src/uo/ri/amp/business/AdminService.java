package uo.ri.amp.business;

import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AsistenciaDTO;
import uo.ri.amp.common.dto.CursoDTO;
import uo.ri.amp.common.dto.MecanicoDTO;
import uo.ri.amp.persistence.model.Curso;
import uo.ri.amp.persistence.model.Mecanico;
import uo.ri.amp.common.util.TableBuilder;

public interface AdminService {
	
    void addGrade(CursoDTO curso) throws BusinessException;
    void deleteGrade(CursoDTO curso) throws BusinessException;
    void updateGrade(CursoDTO curso) throws BusinessException;
    TableBuilder listGrades() throws BusinessException;

    void addAttendance(AsistenciaDTO asistencia) throws BusinessException;
	void deleteAttendance(AsistenciaDTO asistenciaDTO) throws BusinessException;
	void updateAttendance(AsistenciaDTO asistencia) throws BusinessException;
	TableBuilder listAttendance(AsistenciaDTO codigo) throws BusinessException;
	
	String generateCertificates() throws BusinessException;
	
	String listHoursByType() throws BusinessException;
	String listHoursByMechanic(MecanicoDTO mecanico) throws BusinessException;

}
