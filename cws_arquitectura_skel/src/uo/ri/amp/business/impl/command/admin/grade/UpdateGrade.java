package uo.ri.amp.business.impl.command.admin.grade;

import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.CursoDTO;
import uo.ri.amp.persistence.model.Association;
import uo.ri.amp.persistence.model.ContenidoCurso;
import uo.ri.amp.persistence.model.Curso;
import uo.ri.amp.persistence.model.TipoVehiculo;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.util.Jpa;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by Jorge.
 */
public class UpdateGrade implements Command {


    private final CursoDTO curso;
    private Curso c;
    private List<TipoVehiculo> tipoVehiculos;

    public UpdateGrade(CursoDTO curso) {
        this.curso = curso;
    }

    @Override
	public Object execute() throws BusinessException {

        comprobar();

        c.setDescripcion(curso.getDescripcion());
        c.setnHoras(curso.getHorasTotales());
        c.setNombre(curso.getNombre());

        //Modificar datos
        c = Jpa.getManager().merge(c);

        // Modoficar contenidos
        List<ContenidoCurso> contenidoCursos = new LinkedList<>();
        for(ContenidoCurso cc : c.getContenidoCurso())
            contenidoCursos.add(cc);

        for(ContenidoCurso cc : contenidoCursos){
            Jpa.getManager().remove(cc);
            Association.Contiene.unlink(cc);
        }
        for (int i = 0; i < tipoVehiculos.size(); i++) {
            TipoVehiculo aux1 = tipoVehiculos.get(i);
            Integer aux2 = curso.getpHoras().get(i);
            Jpa.getManager().persist(new ContenidoCurso(c, aux1, aux2));
        }

		return null;
	}

    private void comprobar() throws BusinessException {

        //Existe curso
        c = Finder.curso.findByCodigo(curso.getCodigo());
        if (c == null)
            throw new BusinessException("No existe el curso.");

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
