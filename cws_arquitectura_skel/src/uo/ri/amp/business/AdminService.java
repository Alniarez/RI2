package uo.ri.amp.business;

import uo.ri.amp.common.BusinessException;
import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.util.TableBuilder;

public interface AdminService {
	
    void addGrade(Curso curso) throws BusinessException;
    void deleteGrade(Long idCurso) throws BusinessException;
    void updateGrade(Curso curso) throws BusinessException;
    TableBuilder listGrades() throws BusinessException;

    void addAttendance(Asistencia asistencia) throws BusinessException;
	void deleteAttendance(Long idCurso, Long idMecanico) throws BusinessException;
	void updateAttendance(Asistencia asistencia) throws BusinessException;
	TableBuilder listAttendance(Long idCurso) throws BusinessException;
	
	void generateCertificates() throws BusinessException;
	
	String listHoursByType() throws BusinessException;
	String listHoursByMechanic(Mecanico mecanico) throws BusinessException;
	

}
