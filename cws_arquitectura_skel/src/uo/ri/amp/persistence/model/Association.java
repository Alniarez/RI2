package uo.ri.amp.persistence.model;

import uo.ri.amp.persistence.model.types.AveriaStatus;

public class Association {

    public static class Poseer {

        public static void link(Cliente cliente, Vehiculo vehiculo) {

            vehiculo.setCliente(cliente);
            cliente._getVehiculos().add(vehiculo);
        }

        public static void unlink(Cliente cliente, Vehiculo vehiculo) {

            cliente._getVehiculos().remove(vehiculo);
            vehiculo.setCliente(null);

        }

    }

    public static class Clasificar {
        public static void link(TipoVehiculo tipoVehiculo, Vehiculo vehiculo) {
            vehiculo.setTipo(tipoVehiculo);
            tipoVehiculo._getVehiculos().add(vehiculo);
        }

        public static void unlink(TipoVehiculo tipoVehiculo, Vehiculo vehiculo) {
            tipoVehiculo._getVehiculos().remove(vehiculo);
            vehiculo.setTipo(null);
        }
    }

    public static class Pagar {

        public static void link(Cliente cliente, MedioPago medioPago) {
            medioPago.setCliente(cliente);
            cliente._getMediosPago().add(medioPago);
        }

        public static void unlink(Cliente cliente, MedioPago medioPago) {
            cliente._getMediosPago().remove(medioPago);
            medioPago.setCliente(null);

        }


    }

    /* package */ static class Averiar {


        public static void link(Vehiculo vehiculo, Averia averia) {
            averia.setVehiculo(vehiculo);
            vehiculo._getAverias().add(averia);
            vehiculo.setNumAverias(vehiculo.getNumAverias() + 1);

        }

        public static void unlink(Vehiculo vehiculo, Averia averia) {

            vehiculo._getAverias().remove(averia);
            averia.setVehiculo(null);
            vehiculo.setNumAverias(vehiculo.getNumAverias() - 1);

        }


    }

    /* package */ static class Facturar {

        public static void link(Factura factura, Averia averia) {

            averia.setStatus(AveriaStatus.FACTURADA);

            averia.setFactura(factura);

            factura._getAsignadas().add(averia);


        }

        public static void unlink(Factura factura, Averia averia) {

            averia.setStatus(AveriaStatus.ASIGNADA);

            factura._getAsignadas().remove(averia);
            averia.setFactura(null);

        }
    }

    public static class Cargar {

        public static void link(Factura factura, Cargo cargo, MedioPago medioPago) {
            cargo.setFactura(factura);
            cargo.setMedioPago(medioPago);

            factura._getCargos().add(cargo);
            medioPago._getCargos().add(cargo);
            medioPago.setAcumulado(medioPago.getAcumulado() + cargo.getImporte());
        }

        public static void unlink(Cargo cargo) {

            cargo.getFactura()._getCargos().remove(cargo);
            cargo.getMedioPago().setAcumulado(cargo.getMedioPago().getAcumulado() - cargo.getImporte());
            cargo.getMedioPago()._getCargos().remove(cargo);

            cargo.setFactura(null);
            cargo.setMedioPago(null);


        }
    }

    public static class Asignar {

        public static void link(Mecanico mecanico, Averia averia) {

            averia.setMecanico(mecanico);
            averia.setStatus(AveriaStatus.ASIGNADA);
            mecanico._getAsignadas().add(averia);

        }

        public static void unlink(Mecanico mecanico, Averia averia) {
            mecanico._getAsignadas().remove(averia);

            averia.setMecanico(null);

        }
    }

    public static class Intervenir {

        public static void link(Mecanico mecanico, Intervencion intervencion, Averia averia) {
            intervencion.setAveria(averia);
            intervencion.setMecanico(mecanico);

            mecanico._getIntervenciones().add(intervencion);
            averia._getIntervenciones().add(intervencion);

        }


        public static void unlink(Intervencion intervencion) {
            intervencion.getMecanico()._getIntervenciones().remove(intervencion);
            intervencion.getAveria()._getIntervenciones().remove(intervencion);

            intervencion.setAveria(null);
            intervencion.setMecanico(null);
        }


    }

    public static class Sustituir {

        public static void link(Repuesto repuesto, Sustitucion sustitucion, Intervencion intervencion) {
            sustitucion.setRepuesto(repuesto);
            sustitucion.setIntervencion(intervencion);

            repuesto._getSustituciones().add(sustitucion);
            intervencion._getSustituciones().add(sustitucion);

        }

        public static void unlink(Sustitucion sustitucion) {
            sustitucion.getRepuesto()._getSustituciones().remove(sustitucion);
            sustitucion.getIntervencion()._getSustituciones().remove(sustitucion);

            sustitucion.setRepuesto(null);
            sustitucion.setIntervencion(null);

        }
    }

    public static class Contiene {

        public static void link(Curso curso, ContenidoCurso contenidoCurso, TipoVehiculo tipoVehiculo) {
            contenidoCurso.setCurso(curso);
            contenidoCurso.setTipoVehiculo(tipoVehiculo);

            curso._getContenidoCurso().add(contenidoCurso);
            tipoVehiculo._getContenidoCurso().add(contenidoCurso);
        }

        public static void unlink(ContenidoCurso contenidoCurso) {
            contenidoCurso.getCurso()._getContenidoCurso().remove(contenidoCurso);
            contenidoCurso.getTipoVehiculo()._getContenidoCurso().remove(contenidoCurso);

            contenidoCurso.setCurso(null);
            contenidoCurso.setTipoVehiculo(null);

        }

    }

    public static class Asistir {
        public static void link(Curso curso, Asistencia asistencia, Mecanico mecanico) {
            asistencia.setCurso(curso);
            asistencia.setMecanico(mecanico);

            curso._getAsistencias().add(asistencia);
            mecanico._getAsistencias().add(asistencia);
        }

        public static void unlink(Asistencia asistencia) {
            asistencia.getCurso()._getAsistencias().remove(asistencia);
            asistencia.getMecanico()._getAsistencias().remove(asistencia);

            asistencia.setCurso(null);
            asistencia.setMecanico(null);

        }

    }

    public static class Certificar {

        public static void link(TipoVehiculo tipoVehiculo, Experto experto, Mecanico mecanico) {
            experto.setTipoVehiculo(tipoVehiculo);
            experto.setMecanico(mecanico);

            tipoVehiculo._getExpertos().add(experto);
            mecanico._getExpertos().add(experto);

        }

        public static void unlink(Experto experto) {
            experto.getTipoVehiculo()._getExpertos().remove(experto);
            experto.getMecanico()._getExpertos().remove(experto);

            experto.setTipoVehiculo(null);
            experto.setMecanico(null);

        }

    }
}
