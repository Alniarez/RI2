package uo.ri.amp.persistence.finder;

import uo.ri.amp.common.dto.ExpertoDTO;
import uo.ri.amp.persistence.model.Experto;
import uo.ri.amp.persistence.model.Mecanico;
import uo.ri.amp.persistence.model.TipoVehiculo;
import uo.ri.amp.persistence.util.Jpa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge.
 */
public class ExpertoFinder {

    public List<ExpertoDTO> findExpertosSinCertificar() {
        @SuppressWarnings("rawtypes")
		List it = Jpa.getManager()
                .createNamedQuery("Experto.ExpertosSinCertificar").getResultList();
        List<ExpertoDTO> e = new ArrayList<>();

        for (Object o : it) {
            Object[] row = (Object[]) o;
            ExpertoDTO ed = ExpertoDTO.create()
                    .setIdTipoVehiculo((Long) row[0])
                    .setIdMecanico((Long) row[1]);
            e.add(ed);
        }
        return e.size() == 0 ? null : e;
    }

    public List<Experto> findByTipo(TipoVehiculo tipoVehiculo) {
        List<Experto> expertos = Jpa.getManager()
                .createNamedQuery("Experto.findByTipo", Experto.class)
                .setParameter("idTipo", tipoVehiculo.getId())
                .getResultList();
        return expertos.size() == 0 ? null : expertos;
    }

    public Mecanico findbyIdMecanico_Tipo(long idMecanico, Long id) {
        List<Mecanico> expertos = Jpa.getManager()
                .createNamedQuery("Experto.findExpertMechanicByTipo",Mecanico.class)
                .setParameter("idTipo", id)
                .setParameter("idMecanico", idMecanico)
                .getResultList();
        return expertos.size() == 0 ? null : expertos.get(0);
    }
}
