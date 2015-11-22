package uo.ri.amp.persistence.finder;

import uo.ri.amp.common.dto.AveriaDTO;
import uo.ri.amp.persistence.model.Averia;
import uo.ri.amp.persistence.util.Jpa;

import java.util.List;

/**
 * Created by Jorge.
 */
public class AveriaFinder {
    public Averia findOne(AveriaDTO dto) {
        List<Averia> averias = Jpa.getManager().createNamedQuery("Averia.findOne", Averia.class)
                .setParameter("matricula", dto.getMatricula())
                .setParameter("fecha", dto.getFechaEntrada())
                .getResultList();
        return averias.size() == 0 ? null : averias.get(0);
    }
}
