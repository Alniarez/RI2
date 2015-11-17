package uo.ri.amp.ui.admin.action.grade;

import static alb.util.console.Console.println;
import static uo.ri.amp.util.Lector.leerCadena;
import static uo.ri.amp.util.Lector.leerEntero;
import static uo.ri.amp.util.Lector.leerLong;

import java.util.LinkedList;
import java.util.List;

import alb.util.menu.Action;
import uo.ri.amp.common.BusinessException;

/**
 * Created by Jorge.
 */
public class UpdateGradeAction implements Action{

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigo = leerCadena("Código de curso");
        String nombre = leerCadena("Nombre");
        String descripcion = leerCadena("Descripcion");
        int horasTotales = leerEntero("Horas totales");

        List<Long> tiposVehiculo = new LinkedList<>();
        List<Integer> horasVehiculo = new LinkedList<>();

        do {
            tiposVehiculo.add(leerLong("Tipo de vehículo"));
            horasVehiculo.add(leerEntero("Porcentaje de horas dedicadas vehículo"));
        } while (masTipos());

        //Generar modelo

        
        // Mostrar resultado
        println("Se ha modificado el curso.");
    }

    private boolean masTipos() {
        return leerCadena("¿Añadir más tipos? (s/n)").equalsIgnoreCase("s");
    }
}
