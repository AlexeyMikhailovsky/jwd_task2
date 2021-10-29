package by.epam.task2.filler.impl;

import by.epam.task2.entity.Tetraedr;
import by.epam.task2.filler.Filler;
import by.epam.task2.repository.impl.TetraRepositoryImpl;
import java.util.List;

public class RepositoryFillerImpl implements Filler {

    @Override
    public void fillAll(List<Tetraedr> tetraeders) {
        tetraeders.forEach(e -> fillOne(e));
    }

    @Override
    public void fillOne(Tetraedr tetraedr) {
        TetraRepositoryImpl repository = TetraRepositoryImpl.getInstance();
        Filler warehouseFiller = new WarehouseFillerImpl();
        repository.addTetraedr(tetraedr);
        warehouseFiller.fillOne(tetraedr);
    }

}
