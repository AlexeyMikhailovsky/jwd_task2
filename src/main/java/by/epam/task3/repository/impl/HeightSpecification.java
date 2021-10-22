package by.epam.task3.repository.impl;

import by.epam.task3.entity.Tetraedr;
import by.epam.task3.repository.Specification;

public class HeightSpecification implements Specification {
    private double minHeight;
    private double maxHeight;

    public HeightSpecification(double minHeight, double maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean specify(Tetraedr tetra) {
        return (tetra.getHeight() >= minHeight && tetra.getHeight() <= maxHeight);
    }
}
