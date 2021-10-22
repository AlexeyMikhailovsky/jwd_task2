package by.epam.task3.repository;

import by.epam.task3.entity.Tetraedr;
import java.util.Comparator;
import java.util.List;

public interface TetraRepository {

    void addTetraedr(Tetraedr tetra);

    void addAllTetraedrs(List<Tetraedr> tetra);

    boolean removeTetraedr(Tetraedr tetra);

    boolean removeAllTetraedrs(List<Tetraedr> tetra);

    List<Tetraedr> query(Specification specification );

    List sort(Comparator<Tetraedr> comparator);

}
