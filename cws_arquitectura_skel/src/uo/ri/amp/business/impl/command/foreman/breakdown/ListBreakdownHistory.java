package uo.ri.amp.business.impl.command.foreman.breakdown;

import uo.ri.amp.business.impl.command.Command;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.VehiculoDTO;
import uo.ri.amp.common.util.TableBuilder;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.Averia;
import uo.ri.amp.persistence.model.Vehiculo;

import java.util.Set;

/**
 * Created by Jorge.
 */
public class ListBreakdownHistory implements Command {

    private final VehiculoDTO dto;
    private Set<Averia> set;


    public ListBreakdownHistory(VehiculoDTO vehiculo) {
        this.dto = vehiculo;
    }

    @Override
    public Object execute() throws BusinessException {
        comprobar();

        TableBuilder tb = new TableBuilder();
        tb.addRow("Id", "Status", "Fecha", "Descripción");
        tb.addRow("-----", "-----", "-----", "-----");
        for(Averia averia : set) {
            tb.addRow(averia.getId()+"",
                    averia.getStatus().toString(),
                    averia.getFecha().toString(),
                    averia.getDescripcion());
        }
        return tb;
    }

    private void comprobar() throws BusinessException {
        Vehiculo vehiculo = Finder.vehiculo.findByMatricula(dto.getMatricula());
        if (vehiculo == null)
            throw new BusinessException("No existe el vehículo.");
        set = vehiculo.getAverias();
    }

}