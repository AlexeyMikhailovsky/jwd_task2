package by.epam.task3.comparator;

import by.epam.task3.entity.Tetraedr;
import java.util.Comparator;

public class TetraXComparator implements Comparator<Tetraedr> {

    @Override
    public int compare(Tetraedr o1, Tetraedr o2) {
        return Double.compare(o1.getCenter().getX(),o2.getCenter().getX());
    }
}
