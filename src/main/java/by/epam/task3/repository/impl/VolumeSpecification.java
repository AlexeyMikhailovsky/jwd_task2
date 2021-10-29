package by.epam.task3.repository.impl;

import by.epam.task3.entity.Tetraedr;
import by.epam.task3.repository.Specification;
import by.epam.task3.service.impl.TetraServiceImpl;

public class VolumeSpecification implements Specification {

    private final double minVolume;
    private final double maxVolume;

    public VolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(Tetraedr tetraedr) {
        TetraServiceImpl service = new TetraServiceImpl();
        double volume = service.tetraedrVolume(tetraedr);
        return (minVolume <= volume && volume <= maxVolume);
    }
}
