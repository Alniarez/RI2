package uo.ri.amp.persistence.finder;

import uo.ri.amp.common.dto.ExpertoDTO;
import uo.ri.amp.persistence.util.Jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jorge.
 */
public class ExpertoFinder {

    public static List<ExpertoDTO> findExpertosSinCertificar() {
        List it = Jpa.getManager()
                .createNamedQuery("Experto.ExpertosSinCertificar").getResultList();
        List<ExpertoDTO> e = new ArrayList<>();

        for (Object o : it) {
            Object[] row = (Object[]) o;
            ExpertoDTO ed = new ExpertoDTO();
            ed.setIdTipoVehiculo((Long) row[0]);
            ed.setIdMecanico((Long) row[1]);
            e.add(ed);
        }
        return e.size() == 0 ? null : e;
    }
}
