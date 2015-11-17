package uo.ri.amp.business.impl;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.business.impl.command.CommandExecutor;
import uo.ri.amp.business.impl.command.admin.grade.AddGrade;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.util.TableBuilder;


/**
 * Created by Jorge on 17/11/2015.
 */
public class AdminServiceImpl implements AdminService{

    CommandExecutor executor = new CommandExecutor();

    @Override
    public void addGrade(Curso curso) throws BusinessException {
        executor.execute(new AddGrade());
    }

    @Override
    public void deleteGrade(Long idCurso) throws BusinessException {

    }

    @Override
    public void updateGrade(Curso curso) throws BusinessException {

    }

    @Override
    public TableBuilder listGrades() throws BusinessException {
        return null;
    }

    @Override
    public void addAttendance(Asistencia asistencia) throws BusinessException {

    }

    @Override
    public void deleteAttendance(Long idCurso, Long idMecanico) throws BusinessException {

    }

    @Override
    public void updateAttendance(Asistencia asistencia) throws BusinessException {

    }

    @Override
    public TableBuilder listAttendance(Long idCurso) throws BusinessException {
        return null;
    }

    @Override
    public void generateCertificates() throws BusinessException {

    }

    @Override
    public String listHoursByType() throws BusinessException {
        return null;
    }

    @Override
    public String listHoursByMechanic(Mecanico mecanico) throws BusinessException {
        return null;
    }
}
