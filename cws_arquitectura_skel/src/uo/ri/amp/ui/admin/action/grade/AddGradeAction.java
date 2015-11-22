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

public class AddGradeAction implements Action {

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigo = leerCadena("Código de curso");
        String nombre = leerCadena("Nombre");
        String descripcion = leerCadena("Descripcion");
        int horasTotales = leerEntero("Horas totales");

        List<String> tiposVehiculo = new LinkedList<>();
        List<Integer> horasVehiculo = new LinkedList<>();

        do {
            tiposVehiculo.add(leerCadena("Tipo de vehículo (nombre)"));
            horasVehiculo.add(leerEntero("Porcentaje de horas dedicadas al vehículo"));
        } while (masTipos());

        //Generar modelo
        CursoDTO curso = CursoDTO.create()
            .setCodigo(codigo)
            .setNombre(nombre)
            .setDescripcion(descripcion)
            .setHorasTotales(horasTotales)
            .setVehiculos(tiposVehiculo)
            .setpHoras(horasVehiculo);

        //Procesar
        ServiceFactory.getAdminService().addGrade(curso);

        // Mostrar resultado
        println("Se ha añadido el curso.");
    }

    private boolean masTipos(){
        return leerCadena("¿Añadir más tipos? (s/n)").equalsIgnoreCase("s");
    }
}