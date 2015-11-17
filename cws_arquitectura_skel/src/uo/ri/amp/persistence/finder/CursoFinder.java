package uo.ri.amp.persistence.finder;

import uo.ri.amp.model.Curso;
import uo.ri.amp.persistence.util.Jpa;

import java.util.List;

public class CursoFinder {

    public List<Curso> findAll(){

        return Jpa.getManager().createNamedQuery(
                "Curso.findAll",Curso.class)
                .getResultList();
    }

    public Curso findByCodigo(long codigo){
        return Jpa.getManager().createNamedQuery(
                "Curso.findByCodigo",Curso.class)
                .setParameter("codigo",codigo)
                .getSingleResult();
    }

}
