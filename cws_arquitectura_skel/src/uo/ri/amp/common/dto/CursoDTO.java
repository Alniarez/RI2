package uo.ri.amp.common.dto;

import java.util.List;

/**
 * Created by Jorge.
 */
public class CursoDTO {

    private long id;
    private String codigo;
    private String nombre;
    private int horasTotales;
    private String descripcion;
    private List<ContenidoCursoDTO> contenidos;
    private List<String> vehiculos;
    private List<Integer> pHoras;

    public static CursoDTO create(){
        return new CursoDTO();
    }

    public long getId() {
        return id;
    }

    public CursoDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public CursoDTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public CursoDTO setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public int getHorasTotales() {
        return horasTotales;
    }

    public CursoDTO setHorasTotales(int horasTotales) {
        this.horasTotales = horasTotales;
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public CursoDTO setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public List<ContenidoCursoDTO> getContenidos() {
        return contenidos;
    }

    public CursoDTO setContenidos(List<ContenidoCursoDTO> contenidos) {
        this.contenidos = contenidos;
        return this;
    }

    public List<String> getVehiculos() {
        return vehiculos;
    }

    public CursoDTO setVehiculos(List<String> vehiculos) {
        this.vehiculos = vehiculos;
        return this;
    }

    public List<Integer> getpHoras() {
        return pHoras;
    }

    public CursoDTO setpHoras(List<Integer> pHoras) {
        this.pHoras = pHoras;
        return this;
    }
}
