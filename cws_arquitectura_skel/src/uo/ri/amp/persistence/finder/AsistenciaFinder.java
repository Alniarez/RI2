package uo.ri.amp.persistence.finder;

import uo.ri.amp.common.dto.HoraTipoDTO;
import uo.ri.amp.common.dto.HorasAsistenciaDTO;
import uo.ri.amp.common.dto.HorasMecanicoTipoDTO;
import uo.ri.amp.persistence.model.Asistencia;
import uo.ri.amp.persistence.util.Jpa;

import javax.persistence.Query;
import java.util.*;

/**
 * Created by Jorge.
 */
public class AsistenciaFinder {

    public List<Asistencia> findAll() {
        return Jpa.getManager().createNamedQuery(
                "Asistencia.findAll", Asistencia.class)
                .getResultList();
    }

    public Asistencia findOne(String codigo, long idMecanico) {
        List<Asistencia> asistencias;
        asistencias = Jpa.getManager().createNamedQuery(
                "Asistencia.finOne", Asistencia.class)
                .setParameter("codigo", codigo)
                .setParameter("idMecanico", idMecanico)
                .getResultList();
        return asistencias.size() == 0 ? null : asistencias.get(0);
    }

    public List<Asistencia> findByCurso(String codigoCurso) {
        return Jpa.getManager().createNamedQuery(
                "Asistencia.findbyCurso", Asistencia.class)
                .setParameter("codigo", codigoCurso)
                .getResultList();
    }

    /*
    public List<Map<String, Object>> findHoursByMechanic(long id) {
        List<Map<String, Object>> result = new LinkedList<>();
        Map<String, Object> map;
        Iterator iterator;
        iterator = Jpa.getManager().createNamedQuery("Asistencia.hourByMechanicA").setParameter("idMecanico", id).getResultList().iterator();
        while (iterator.hasNext()) {
            Object[] row = (Object[]) iterator.next();
            map = new HashMap<String, Object>();
            map.put("horasCursadas", (Long) row[0]);
            map.put("horasTotales", (Long) row[1]);
            result.add(map);
        }
        iterator = Jpa.getManager().createNamedQuery("Asistencia.hourByMechanicB").setParameter("idMecanico", id).getResultList().iterator();
        while (iterator.hasNext()) {
            Object[] row = (Object[]) iterator.next();
            map = new HashMap<String, Object>();
            map.put("tipo", row[0].toString());
            map.put("horas", (Long) row[1]);
            result.add(map);
        }

        return null;
    }
    */

    public HorasAsistenciaDTO findHoursByMechanicA(long id) {
        List<HorasAsistenciaDTO> horas = new LinkedList<>();
        @SuppressWarnings("rawtypes")
		List resultList = Jpa.getManager()
                .createNamedQuery("Asistencia.hourByMechanicA")
                .setParameter("idMecanico", id)
                .getResultList();
        for (Object iterator : resultList) {
            Object[] row = (Object[]) iterator;
            horas.add(HorasAsistenciaDTO.create()
                    .setHorasCursadas((Long) row[0])
                    .setHorasTotales((Long) row[1]));
        }
        return horas.isEmpty() ? null : horas.get(0);
    }

    public List<HoraTipoDTO> findHoursByMechanicB(long id) {
        List<HoraTipoDTO> horas = new LinkedList<>();
        @SuppressWarnings("rawtypes")
		List resultList = Jpa.getManager()
                .createNamedQuery("Asistencia.hourByMechanicB")
                .setParameter("idMecanico", id)
                .getResultList();
        for (Object iterator : resultList) {
            Object[] row = (Object[]) iterator;
            horas.add(HoraTipoDTO.create()
                    .setHoras((Long) row[0])
                    .setIdTipo((Long) row[1]));
        }
        return horas;
    }

    public List<HorasMecanicoTipoDTO> findHoursByType() {
        List<HorasMecanicoTipoDTO> horas = new LinkedList<>();
        Query q = Jpa.getManager().createNamedQuery("Asistencia.hoursByType");
        @SuppressWarnings("rawtypes")
		List resultList = q.getResultList();

        for (Object iterator : resultList) {
            Object[] row = (Object[]) iterator;
            horas.add(HorasMecanicoTipoDTO.create()
                    .setIdTipo((Long) row[0])
                    .setIdMecanico((Long) row[1])
                    .setHoras((Long) row[2]));
        }
        return horas;
    }
}

