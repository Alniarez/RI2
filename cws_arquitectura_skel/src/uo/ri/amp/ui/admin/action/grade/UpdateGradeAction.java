package uo.ri.amp.ui.admin.action.grade;

import static alb.util.console.Console.println;
import static uo.ri.amp.common.util.Lector.leerCadena;
import static uo.ri.amp.common.util.Lector.leerEntero;

import java.util.LinkedList;
import java.util.List;

import alb.util.menu.Action;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.common.dto.CursoDTO;

/**
 * Created by Jorge.
 */
public class UpdateGradeAction implements Action{

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigo = leerCadena("C�digo de curso");
        String nombre = leerCadena("Nombre");
        String descripcion = leerCadena("Descripci�n");
        int horasTotales = leerEntero("Horas totales");

        List<String> tiposVehiculo = new LinkedList<>();
        List<Integer> horasVehiculo = new LinkedList<>();

        do {
            tiposVehiculo.add(leerCadena("Tipo de veh�culo"));
            horasVehiculo.add(leerEntero("Porcentaje de horas dedicadas veh�culo"));
        } while (masTipos());

        //Generar modelo
        CursoDTO curso = CursoDTO.create()
            .setCodigo(codigo)
            .setNombre(nombre)
            .setDescripcion(descripcion)
            .setHorasTotales(horasTotales)
            .setVehiculos(tiposVehiculo)
            .setpHoras(horasVehiculo);

        // Realizar
        ServiceFactory.getAdminService().updateGrade(curso);

        // Mostrar resultado
        println("Se ha modificado el curso.");
    }

    private boolean masTipos() {
        return leerCadena("�A�adir m�s tipos? (s/n)").equalsIgnoreCase("s");
    }
}
