package by.epam.task2.repository.impl;

import by.epam.task2.entity.Tetraedr;
import by.epam.task2.repository.Specification;

public class IdSpecification implements Specification {

    private long figureId;

    public IdSpecification(long figureId) {
        this.figureId = figureId;
    }

    @Override
    public boolean specify(Tetraedr tetraedr) {
        return tetraedr.getTetraId() == figureId;
    }
}
