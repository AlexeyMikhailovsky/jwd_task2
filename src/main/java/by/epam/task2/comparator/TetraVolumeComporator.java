package by.epam.task2.comparator;

import by.epam.task2.entity.Tetraedr;
import by.epam.task2.service.impl.TetraServiceImpl;
import java.util.Comparator;

public class TetraVolumeComporator implements Comparator<Tetraedr> {

    @Override
    public int compare(Tetraedr o1, Tetraedr o2) {
        TetraServiceImpl tetraService = new TetraServiceImpl();
        double firstTetraedrVolume = tetraService.tetraedrVolume(o1);
        double secondTetraedrVolume = tetraService.tetraedrVolume(o2);
        return Double.compare(firstTetraedrVolume,secondTetraedrVolume);
    }

}
