package by.epam.task2.factory;

import by.epam.task2.entity.Point;
import by.epam.task2.entity.Tetraedr;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TetraFactoryTest {

    Tetraedr actualTetraedr;
    Tetraedr expectedTetraedr;
    Point center = new Point(5,6,7);

    @Test
    void testcreateTetra() {
        expectedTetraedr = TetraFactory.createTetraedr(center,8,9);
        actualTetraedr = TetraFactory.createTetraedr(center,8,9);
        actualTetraedr.setTetraId(0);
        assertEquals(expectedTetraedr,actualTetraedr);
    }

    @Test
    void testCreateTetraByParam(){
        double [] actualTetraValues = {2.1,6.4,2.7,6.4,2.6};
        double [] expectedTetraValues = {2.1,6.4,2.7,6.4,2.6};
        actualTetraedr = TetraFactory.createTetraedr(actualTetraValues);
        expectedTetraedr = TetraFactory.createTetraedr(expectedTetraValues);
        expectedTetraedr.setTetraId(0);
        assertEquals(actualTetraedr, expectedTetraedr);
    }

}
