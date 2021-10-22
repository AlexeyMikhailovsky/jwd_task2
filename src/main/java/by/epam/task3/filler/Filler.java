package by.epam.task3.filler;

import by.epam.task3.entity.Tetraedr;

import java.util.List;

public interface Filler {

    void fillAll(List<Tetraedr> tetraedrs);

    void fillOne(Tetraedr tetraedr);

}
