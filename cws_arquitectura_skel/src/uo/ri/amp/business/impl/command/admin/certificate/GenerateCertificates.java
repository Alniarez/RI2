package uo.ri.amp.business.impl.command.admin.certificate;


import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.ExpertoDTO;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.Experto;
import uo.ri.amp.persistence.model.Mecanico;
import uo.ri.amp.persistence.model.TipoVehiculo;
import uo.ri.amp.persistence.util.Jpa;

import java.util.Date;
import java.util.List;

public class GenerateCertificates implements Command {

    @Override
	public Object execute() throws BusinessException {
        List<ExpertoDTO> expertos = Finder.experto.findExpertosSinCertificar();
        if(expertos==null)
            return "No se crado ningún certificado.";

        StringBuilder sb = new StringBuilder();

        for(ExpertoDTO expertoDTO : expertos){
            TipoVehiculo tipoVehiculo = Finder.tipoVehiculo.findById(
                    expertoDTO.getIdTipoVehiculo());
            Mecanico mecanico = Finder.mecanico.findById(expertoDTO.getIdMecanico());
            sb.append("Se va a añadir el experto ")
                    .append(mecanico.getNombre())
                    .append(" en ")
                    .append(tipoVehiculo.getNombre())
                    .append(".\n");
            Jpa.getManager().persist(
                    new Experto(new Date(), tipoVehiculo, mecanico));
        }
        return sb.toString();
    }
}
