package by.epam.task2.filler.impl;

import by.epam.task2.entity.Tetraedr;
import by.epam.task2.filler.Filler;
import by.epam.task2.service.TetraService;
import by.epam.task2.service.impl.TetraServiceImpl;
import by.epam.task2.warehouse.TetraParameters;
import by.epam.task2.warehouse.TetraWarehouse;
import java.util.List;

public class WarehouseFillerImpl implements Filler {

    @Override
    public void fillAll(List<Tetraedr> tetraeders) {
        tetraeders.forEach(e -> fillOne(e));
    }

    @Override
    public void fillOne(Tetraedr tetraedr) {
        TetraWarehouse warehouse = TetraWarehouse.getInstance();
        TetraService service = new TetraServiceImpl();
        double area = service.tetraedrArea(tetraedr);
        double volume = service.tetraedrVolume(tetraedr);
        TetraParameters param = new TetraParameters(area, volume);
        warehouse.putParameters(tetraedr.getTetraId(), param);
    }
}
