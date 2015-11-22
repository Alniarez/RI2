package uo.ri.amp.persistence.finder;

import uo.ri.amp.persistence.model.TipoVehiculo;
import uo.ri.amp.persistence.util.Jpa;

import java.util.List;

/**
 * Created by Jorge.
 */
public class TipoVehiculoFinder {

    public TipoVehiculo findByNombre(String nombre){
        List<TipoVehiculo> tipos =
         Jpa.getManager().createNamedQuery(
                "TipoVehiculo.findByNombre", TipoVehiculo.class).setParameter("nombre", nombre).getResultList();
        return tipos.size()==0 ? null : tipos.get(0);
    }


    public TipoVehiculo findById(long idTipoVehiculo) {
        List<TipoVehiculo> tipos =
                Jpa.getManager().createNamedQuery(
                        "TipoVehiculo.findById", TipoVehiculo.class).setParameter("id", idTipoVehiculo).getResultList();
        return tipos.size()==0 ? null : tipos.get(0);
    }
}
