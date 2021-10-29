package by.epam.task2.filler;

import by.epam.task2.entity.Tetraedr;
import java.util.List;

public interface Filler {

    void fillAll(List<Tetraedr> tetraedrs);

    void fillOne(Tetraedr tetraedr);

}
