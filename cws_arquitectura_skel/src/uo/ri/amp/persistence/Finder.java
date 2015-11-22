package uo.ri.amp.persistence;

import uo.ri.amp.persistence.finder.*;

public class Finder {

    public static CursoFinder curso = new CursoFinder();

    public static ContenidoCursoFinder contenidoCurso = new ContenidoCursoFinder();

    public static ExpertoFinder experto = new ExpertoFinder();

    public static AsistenciaFinder asistencia = new AsistenciaFinder();

    public static TipoVehiculoFinder tipoVehiculo = new TipoVehiculoFinder();

    public static MecanicoFinder mecanico = new MecanicoFinder();

    public static AveriaFinder averia = new AveriaFinder();

    public static VehiculoFinder vehiculo = new VehiculoFinder();
}
