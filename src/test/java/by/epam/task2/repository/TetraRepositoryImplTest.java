package by.epam.task2.repository;

import by.epam.task2.comparator.TetraHeightComparator;
import by.epam.task2.entity.Point;
import by.epam.task2.entity.Tetraedr;
import by.epam.task2.repository.impl.IdSpecification;
import by.epam.task2.repository.impl.TetraRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TetraRepositoryImplTest {

    TetraRepositoryImpl repository;
    Tetraedr tetra1;
    Tetraedr tetra2;
    List<Tetraedr> tetraList;
    Point point;

    @BeforeMethod
    public void initialize() {
        point = new Point(5, 6, 7);
        tetra1 = new Tetraedr(point, 8, 2);
        tetra2 = new Tetraedr(point, 5, 6);
        repository = new TetraRepositoryImpl();
        tetraList = new ArrayList<>();
    }

    @Test
    void size() {
        repository.addTetraedr(tetra1);
        assertEquals(repository.size(),1);
    }

    @Test
    void getById() {
        repository.addTetraedr(tetra1);
        assertEquals(repository.get(0), tetra1);
    }

    @Test
    void addTetraedr() {
        repository.addTetraedr(tetra1);
        int expected= 1;
        assertEquals(expected, repository.size());
    }

    @Test
    void addAllTetraedrs() {
        tetraList.add(tetra1);
        tetraList.add(tetra2);
        repository.addAllTetraedrs(tetraList);
        assertTrue(tetraList.contains(repository.get(0)));
    }

    @Test
    void removeTetrahedron() {
        addAllTetraedrs();
        repository.removeTetraedr(tetra1);
        int expected = 1;
        assertEquals(expected, repository.size());
    }

    @Test
    void removeAllTetrahedrons() {
        addAllTetraedrs();
        assertTrue(repository.removeAllTetraedrs(tetraList));
    }

    @Test
    void query() {
        addTetraedr();
        IdSpecification specification = new IdSpecification(0);
        assertEquals(repository.query(specification),repository.get(0));
    }

    @Test
    void sort() {
        addAllTetraedrs();
        TetraHeightComparator comparator = new TetraHeightComparator();
        repository.sort(comparator);
        assertEquals(repository.get(0), tetra1);
    }

}
