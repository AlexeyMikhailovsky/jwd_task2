package by.epam.task2.repository.impl;

import by.epam.task2.entity.Tetraedr;
import by.epam.task2.repository.Specification;
import by.epam.task2.service.impl.TetraServiceImpl;

public class AreaSpecification  implements Specification {

    private double minArea;
    private double maxArea;

    public AreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specify(Tetraedr tetra) {
        TetraServiceImpl service = new TetraServiceImpl();
        double area = service.tetraedrArea(tetra);
        return (area >= minArea && area <= maxArea);
    }
}
