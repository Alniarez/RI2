package uo.ri.amp.model;

import uo.ri.amp.model.types.AveriaStatus;

public class Association {

	public static class Poseer {

		public static void link(Cliente cliente, Vehiculo vehiculo) {
			
			vehiculo.setCliente(cliente);			
			cliente.getVehiculos().add(vehiculo);
				
			
		}

		public static void unlink(Cliente cliente, Vehiculo vehiculo) {

			cliente.getVehiculos().remove(vehiculo);
			vehiculo.setCliente(null);
			
		}
		
	}

	public static class Clasificar {

		public static void link(TipoVehiculo tipoVehiculo, Vehiculo vehiculo) {
			vehiculo.setTipo(tipoVehiculo);
			
			tipoVehiculo.getVehiculos().add(vehiculo);
		}

		public static void unlink(TipoVehiculo tipoVehiculo, Vehiculo vehiculo) {
			tipoVehiculo.getVehiculos().remove(vehiculo);
			
			vehiculo.setTipo(null);
			
		}
	}

	public static class Pagar {

		public static void link(Cliente cliente, MedioPago medioPago)
		{
			medioPago.setCliente(cliente);
			
			cliente.getMediosPago().add(medioPago);
			
		}
		
		public static void unlink(Cliente cliente, MedioPago medioPago) {
			cliente.getMediosPago().remove(medioPago);
			
			medioPago.setCliente(null);
			
		}

		
	}

	/* package */ static class Averiar {

	
		public static void link(Vehiculo vehiculo, Averia averia) {
			averia.setVehiculo(vehiculo);
			vehiculo.getAverias().add(averia);
			vehiculo.setNumAverias(vehiculo.getNumAverias()+1);
			
		}
		
		public static void unlink(Vehiculo vehiculo, Averia averia) {
			
			vehiculo.getAverias().remove(averia);
			averia.setVehiculo(null);
			vehiculo.setNumAverias(vehiculo.getNumAverias()-1);
			
		}
		
			
	}

	/* package */ static class Facturar {

		public static void link(Factura factura, Averia averia) {
			
			averia.setStatus(AveriaStatus.FACTURADA);
			
			averia.setFactura(factura);
			
			factura.getAsignadas().add(averia);
			
			
		}

		public static void unlink(Factura factura, Averia averia) {
			
			averia.setStatus(AveriaStatus.ASIGNADA);
			
			factura.getAsignadas().remove(averia);
			averia.setFactura(null);
			
		}
	}

	public static class Cargar {

		public static void link(Factura factura, Cargo cargo, MedioPago medioPago) {
			cargo.setFactura(factura);
			cargo.setMedioPago(medioPago);
			
			factura.getCargos().add(cargo);
			medioPago.getCargos().add(cargo);
			medioPago.setAcumulado(medioPago.getAcumulado()+cargo.getImporte());
		}

		public static void unlink(Cargo cargo) {
			
			cargo.getFactura().getCargos().remove(cargo);
			cargo.getMedioPago().setAcumulado(cargo.getMedioPago().getAcumulado()-cargo.getImporte());
			cargo.getMedioPago().getCargos().remove(cargo);
			
			cargo.setFactura(null);
			cargo.setMedioPago(null);
			
			
		}
	}
	
	public static class Asignar {

		public static void link(Mecanico mecanico, Averia averia) {
			
			averia.setMecanico(mecanico);
			averia.setStatus(AveriaStatus.ASIGNADA);
			mecanico.getAsignadas().add(averia);
			
		}

		public static void unlink(Mecanico mecanico, Averia averia) {
			mecanico.getAsignadas().remove(averia);
			
			averia.setMecanico(null);
			
		}
	}

	public static class Intervenir {

		public static void link(Mecanico mecanico, Intervencion intervencion, Averia averia) {
			intervencion.setAveria(averia);
			intervencion.setMecanico(mecanico);
			
			mecanico.getIntervenciones().add(intervencion);
			averia.getIntervenciones().add(intervencion);
			
		}
		

		public static void unlink(Intervencion intervencion) {
			intervencion.getMecanico().getIntervenciones().remove(intervencion);
			intervencion.getAveria().getIntervenciones().remove(intervencion);
			
			intervencion.setAveria(null);
			intervencion.setMecanico(null);
		}

		
	}

	public static class Sustituir {

		public static void link(Repuesto repuesto, Sustitucion sustitucion, Intervencion intervencion) {
			sustitucion.setRepuesto(repuesto);
			sustitucion.setIntervencion(intervencion);
			
			repuesto.getSustituciones().add(sustitucion);
			intervencion.getSustituciones().add(sustitucion);
			
		}

		public static void unlink(Sustitucion sustitucion) {
			sustitucion.getRepuesto().getSustituciones().remove(sustitucion);
			sustitucion.getIntervencion().getSustituciones().remove(sustitucion);
			
			sustitucion.setRepuesto(null);
			sustitucion.setIntervencion(null);
			
		}
	}
	
	public static class Ofertar{

		public static void link(Curso curso, ContenidoCurso oferta, TipoVehiculo tipoVehiculo) {
			oferta.setCurso(curso);
			oferta.setTipoVehiculo(tipoVehiculo);
			
			curso.getContenidoCurso().add(oferta);
			tipoVehiculo.getContenidoCurso().add(oferta);
		}
		
		public static void unlink(Curso curso, ContenidoCurso oferta, TipoVehiculo tipoVehiculo) {
			
			curso.getContenidoCurso().remove(oferta);
			tipoVehiculo.getContenidoCurso().remove(oferta);
			
			oferta.setCurso(null);
			oferta.setTipoVehiculo(null);
			
		}
		
	}
	public static class Asistir{

		public static void link(Curso curso, Asistencia asistencia, Mecanico mecanico) {
			asistencia.setCurso(curso);
			asistencia.setMecanico(mecanico);
			
			curso.getAsistencias().add(asistencia);
			mecanico.getAsistencias().add(asistencia);
			
			
		}
		
		public static void unlink(Asistencia asistencia) {
			asistencia.getCurso().getAsistencias().remove(asistencia);
			asistencia.getMecanico().getAsistencias().remove(asistencia);
			
			asistencia.setCurso(null);
			asistencia.setMecanico(null);
			
		}
		
	}
	public static class Certificar{

		public static void link(TipoVehiculo tipoVehiculo, Experto experto, Mecanico mecanico) {
			experto.setTipoVehiculo(tipoVehiculo);
			experto.setMecanico(mecanico);
			
			tipoVehiculo.getExpertos().add(experto);
			mecanico.getExpertos().add(experto);
			
		}
		
		public static void unlink(Experto experto){
			experto.getTipoVehiculo().getExpertos().remove(experto);
			experto.getMecanico().getExpertos().remove(experto);
			
			experto.setTipoVehiculo(null);
			experto.setMecanico(null);
			
		}
		
	}
}
