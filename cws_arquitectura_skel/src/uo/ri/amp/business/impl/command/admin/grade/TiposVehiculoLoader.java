package uo.ri.amp.business.impl.command.admin.grade;

import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.CursoDTO;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.TipoVehiculo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jorge.
 */
public class TiposVehiculoLoader {

    static public List<TipoVehiculo> load(CursoDTO curso)
            throws BusinessException {
        LinkedList<TipoVehiculo> tipoVehiculos = new LinkedList<>();
        for (String tv : curso.getVehiculos()) {
            TipoVehiculo aux = Finder.tipoVehiculo.findByNombre(tv);
            if (aux == null)
                throw new BusinessException("No existse el tipo de vehículo "
                        + tv+".");
            else {
                tipoVehiculos.add(aux);
            }
        }
        return tipoVehiculos;
    }
}
