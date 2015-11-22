package uo.ri.amp.business.impl.command.admin.grade;


import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.CursoDTO;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.ContenidoCurso;
import uo.ri.amp.persistence.model.Curso;
import uo.ri.amp.persistence.model.TipoVehiculo;
import uo.ri.amp.persistence.util.Jpa;

import java.util.List;

/**
 * Created by Jorge.
 */
public class AddGrade implements Command {

    private final CursoDTO curso;

    public AddGrade(CursoDTO curso) {
        this.curso = curso;
    }

    @Override
    public Object execute() throws BusinessException {

        comprobar();

        Curso c = new Curso(curso.getCodigo(), curso.getNombre(), curso.getDescripcion(), curso.getHorasTotales(),
        tipoVehiculos,curso.getpHoras());

        Jpa.getManager().persist(c);
        for (int i = 0; i < tipoVehiculos.size(); i++) {
            Jpa.getManager().persist(new ContenidoCurso(c, tipoVehiculos.get(i), curso.getpHoras().get(i)));
        }
        return null;
    }

    private List<TipoVehiculo> tipoVehiculos;
    private void comprobar() throws BusinessException {
        //No existe curso
        if (Finder.curso.findByCodigo(curso.getCodigo()) != null)
            throw new BusinessException("Ya existe el curso.");

        //Los tipos existen
        tipoVehiculos = TiposVehiculoLoader.load(curso);

        //Horas totales positivas
        if(curso.getHorasTotales()<=0)
            throw new BusinessException("Las horas deben ser positivas.");

        //Suma porcentajes
        int porcentajeAcumulado = 0;
        for(Integer integer : curso.getpHoras()) {
            if(integer<=0)
                throw new BusinessException("Debe usar porcentajes postivos.");
            porcentajeAcumulado += integer;
        }
        if(porcentajeAcumulado!= 100)
            throw new BusinessException("La suma de los porcetajes debe ser 100.");

    }
}
