package uo.ri.amp.persistence.finder;

import uo.ri.amp.persistence.model.Curso;
import uo.ri.amp.persistence.util.Jpa;

import java.util.List;

public class CursoFinder {

    public List<Curso> findAll(){
        return Jpa.getManager().createNamedQuery(
                "Curso.findAll",Curso.class)
                .getResultList();
    }

    public Curso findByCodigo(String codigo){
        List<Curso> cursos = Jpa.getManager().createNamedQuery(
                "Curso.findByCodigo",Curso.class)
                .setParameter("codigo",codigo)
                .getResultList();
        return cursos.size()==0 ? null :cursos.get(0);
    }

    public Curso findById(Long id){
        List<Curso> cursos = Jpa.getManager().createNamedQuery(
                "Curso.findById",Curso.class)
                .setParameter("id", id)
                .getResultList();
        return cursos.size()==0 ? null :cursos.get(0);
    }
}
