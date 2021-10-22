package by.epam.task3.filler.impl;

import by.epam.task3.entity.Tetraedr;
import by.epam.task3.filler.Filler;
import by.epam.task3.repository.impl.TetraRepositoryImpl;
import java.util.List;

public class RepositoryFiller implements Filler {

    @Override
    public void fillAll(List<Tetraedr> tetraeders) {
        tetraeders.forEach(e -> fillOne(e));
    }

    @Override
    public void fillOne(Tetraedr tetraedr) {
        TetraRepositoryImpl repository = TetraRepositoryImpl.getInstance();
        Filler warehouseFiller = new WarehouseFiller();
        repository.addTetraedr(tetraedr);
        warehouseFiller.fillOne(tetraedr);
    }

}
