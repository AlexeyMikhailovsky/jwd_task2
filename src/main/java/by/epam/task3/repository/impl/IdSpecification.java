package by.epam.task3.repository.impl;

import by.epam.task3.entity.Tetraedr;
import by.epam.task3.repository.Specification;

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
