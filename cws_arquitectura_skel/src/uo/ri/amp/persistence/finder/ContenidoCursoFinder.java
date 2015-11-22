package uo.ri.amp.persistence.finder;

import uo.ri.amp.persistence.model.ContenidoCurso;
import uo.ri.amp.persistence.util.Jpa;

import java.util.List;

/**
 * Created by Jorge on 17/11/2015.
 */
public class ContenidoCursoFinder {

    public List<ContenidoCurso> findByIdCurso(Long id){
        List<ContenidoCurso> result;
        result = Jpa.getManager().createNamedQuery(
                "ContenidoCurso.findByCursoId",ContenidoCurso.class)
                .setParameter("id", id)
                .getResultList();
        return result;
    }




}
