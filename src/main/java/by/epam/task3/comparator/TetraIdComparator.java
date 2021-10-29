package by.epam.task3.comparator;

import by.epam.task3.entity.Tetraedr;
import java.util.Comparator;

public class TetraIdComparator implements Comparator<Tetraedr> {

    @Override
    public int compare(Tetraedr o1, Tetraedr o2) {
        return Long.compare(o1.getTetraId(),o2.getTetraId());
    }
}
