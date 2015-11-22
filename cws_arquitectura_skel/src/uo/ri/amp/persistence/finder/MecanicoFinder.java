package uo.ri.amp.persistence.finder;

import uo.ri.amp.persistence.model.Mecanico;
import uo.ri.amp.persistence.util.Jpa;

import java.util.List;

/**
 * Created by Jorge on 18/11/2015.
 */
public class MecanicoFinder {

    public Mecanico findById(long id) {
        List<Mecanico> mecanicos;
        mecanicos = Jpa.getManager().createNamedQuery(
                "Mecanicos.findById",Mecanico.class)
                .setParameter("id", id)
                .getResultList();
        return mecanicos.size()==0 ? null : mecanicos.get(0);
    }


}
