package uo.ri.amp.business.impl;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.business.impl.command.CommandExecutor;
import uo.ri.amp.business.impl.command.admin.attendance.AddAttendance;
import uo.ri.amp.business.impl.command.admin.attendance.DeleteAttendance;
import uo.ri.amp.business.impl.command.admin.attendance.ListAttendance;
import uo.ri.amp.business.impl.command.admin.attendance.UpdateAttendance;
import uo.ri.amp.business.impl.command.admin.certificate.GenerateCertificates;
import uo.ri.amp.business.impl.command.admin.grade.AddGrade;
import uo.ri.amp.business.impl.command.admin.grade.DeleteGrade;
import uo.ri.amp.business.impl.command.admin.grade.ListGrades;
import uo.ri.amp.business.impl.command.admin.grade.UpdateGrade;
import uo.ri.amp.business.impl.command.admin.list.ListHoursByMechanic;
import uo.ri.amp.business.impl.command.admin.list.ListHoursByType;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AsistenciaDTO;
import uo.ri.amp.common.dto.CursoDTO;
import uo.ri.amp.common.dto.MecanicoDTO;
import uo.ri.amp.common.util.TableBuilder;


/**
 * Created by Jorge.
 */
public class AdminServiceImpl implements AdminService{

    private CommandExecutor executor = new CommandExecutor();

    @Override
    public void addGrade(CursoDTO curso) throws BusinessException {
        executor.execute(new AddGrade(curso));
    }

    @Override
    public void deleteGrade(CursoDTO curso) throws BusinessException {
        executor.execute(new DeleteGrade(curso));
    }

    @Override
    public void updateGrade(CursoDTO curso) throws BusinessException {
        executor.execute(new UpdateGrade(curso));
    }

    @Override
    public TableBuilder listGrades() throws BusinessException {
        return (TableBuilder) executor.execute(new ListGrades());
    }

    @Override
    public void addAttendance(AsistenciaDTO asistencia) throws BusinessException {
        executor.execute(new AddAttendance(asistencia));
    }

    @Override
    public void deleteAttendance(AsistenciaDTO asistencia) throws BusinessException {
        executor.execute(new DeleteAttendance(asistencia));
    }

    @Override
    public void updateAttendance(AsistenciaDTO asistencia) throws BusinessException {
        executor.execute(new UpdateAttendance(asistencia));
    }

    @Override
    public TableBuilder listAttendance(AsistenciaDTO asistenciaDTO) throws BusinessException {
        return (TableBuilder) executor.execute(new ListAttendance(asistenciaDTO));
    }

    @Override
    public String generateCertificates() throws BusinessException {
        return (String) executor.execute(new GenerateCertificates());
    }

    @Override
    public String listHoursByType() throws BusinessException {
        return (String) executor.execute(new ListHoursByType());
    }

    @Override
    public String listHoursByMechanic(MecanicoDTO mecanico) throws BusinessException {
        return (String) executor.execute(new ListHoursByMechanic(mecanico));
    }
}
