package by.epam.task2.filler;

import by.epam.task2.entity.Point;
import by.epam.task2.entity.Tetraedr;
import by.epam.task2.filler.impl.RepositoryFillerImpl;
import by.epam.task2.repository.impl.TetraRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class RepositoryFillerTest {

    private Filler repositoryFiller = new RepositoryFillerImpl();;

    @Test
    public void testFillAll() {
        List<Tetraedr> expected = new ArrayList<Tetraedr>();
        expected.add(new Tetraedr(new Point(1, 2,3),4,5));
        expected.add(new Tetraedr(new Point(1, 4,6), 8,10));
        expected.add(new Tetraedr(new Point(1, 6,3), 2,4));
        repositoryFiller.fillAll(expected);
        TetraRepositoryImpl repository = TetraRepositoryImpl.getInstance();
        List<Tetraedr> actual = repository.getRepository();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFillOne() {
        Tetraedr expected = new Tetraedr(new Point(1, 2,3), 4,5);
        repositoryFiller.fillOne(expected);
        TetraRepositoryImpl repository = TetraRepositoryImpl.getInstance();
        Tetraedr actual = repository.get(repository.size() - 1);
        Assert.assertEquals(actual, expected);
    }
}
