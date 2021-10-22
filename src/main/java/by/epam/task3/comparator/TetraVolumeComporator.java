package by.epam.task3.comparator;

import by.epam.task3.entity.Tetraedr;
import by.epam.task3.service.impl.TetraServiceImpl;

import java.util.Comparator;

public class TetraVolumeComporator implements Comparator<Tetraedr> {

    @Override
    public int compare(Tetraedr o1, Tetraedr o2) {
        TetraServiceImpl calculation = new TetraServiceImpl();
        double firsTetraVolume = calculation.tetraedrVolume(o1);
        double secondTetraVolume = calculation.tetraedrVolume(o2);
        return Double.compare(firsTetraVolume,secondTetraVolume);
    }

}
