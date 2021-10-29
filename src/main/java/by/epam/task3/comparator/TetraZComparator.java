package by.epam.task3.comparator;

import by.epam.task3.entity.Tetraedr;
import java.util.Comparator;

public class TetraZComparator implements Comparator<Tetraedr> {

    @Override
    public int compare(Tetraedr o1, Tetraedr o2) {
        return Double.compare(o1.getCenter().getZ(), o2.getCenter().getZ());
    }
}
