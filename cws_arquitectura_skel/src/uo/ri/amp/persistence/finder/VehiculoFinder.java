package uo.ri.amp.persistence.finder;

import uo.ri.amp.persistence.model.Vehiculo;
import uo.ri.amp.persistence.util.Jpa;

import java.util.List;

/**
 * Created by Jorge.
 */
public class VehiculoFinder {
    public Vehiculo findByMatricula(String matricula) {
        List<Vehiculo> v = Jpa.getManager().createNamedQuery("Vehiculo.getByMatricula", Vehiculo.class)
                .setParameter("matricula", matricula).getResultList();
        return v.size() == 0 ? null : v.get(0);
    }
}
