package uo.ri.amp.persistence;

import uo.ri.amp.persistence.finder.AsistenciaFinder;
import uo.ri.amp.persistence.finder.ContenidoCursoFinder;
import uo.ri.amp.persistence.finder.CursoFinder;
import uo.ri.amp.persistence.finder.ExpertoFinder;

public class Finder {

    public static CursoFinder curso = new CursoFinder();

    public static ContenidoCursoFinder contenidoCurso = new ContenidoCursoFinder();

    public static ExpertoFinder experto = new ExpertoFinder();

    public static AsistenciaFinder asistencia = new AsistenciaFinder();

}
