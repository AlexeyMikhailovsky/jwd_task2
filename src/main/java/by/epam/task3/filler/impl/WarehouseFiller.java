package by.epam.task3.filler.impl;

import by.epam.task3.entity.Tetraedr;
import by.epam.task3.filler.Filler;
import by.epam.task3.service.TetraService;
import by.epam.task3.service.impl.TetraServiceImpl;
import by.epam.task3.warehouse.TetraParameters;
import by.epam.task3.warehouse.TetraWarehouse;

import java.util.List;

public class WarehouseFiller implements Filler {

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
