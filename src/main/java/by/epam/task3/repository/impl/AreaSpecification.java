package by.epam.task3.repository.impl;

import by.epam.task3.entity.Tetraedr;
import by.epam.task3.repository.Specification;
import by.epam.task3.service.impl.TetraServiceImpl;

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
