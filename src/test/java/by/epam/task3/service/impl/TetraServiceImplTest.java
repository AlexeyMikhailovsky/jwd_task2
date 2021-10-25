package by.epam.task3.service.impl;

import by.epam.task3.entity.Point;
import by.epam.task3.entity.Tetraedr;
import by.epam.task3.exception.CustomException;
import by.epam.task3.factory.TetraFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TetraServiceImplTest {

    @Test
    public void isTetraedr() {
        TetraServiceImpl  tetraService = new TetraServiceImpl();
        boolean isTetraedr = tetraService.isTetraedr(4,7);
        assertTrue(isTetraedr);
    }

    @Test
    public void tetraedrVolume() {
        TetraServiceImpl  tetraService = new TetraServiceImpl();
        Point point = new Point(1,2,3);
        Tetraedr tetredr = TetraFactory.createTetraedr(point,4,5);
        double actualVolume = tetraService.tetraedrVolume(tetredr);
        double expectedVolume = 46.19;
        assertEquals(actualVolume,expectedVolume,0.01);
    }

    @Test
    public void tetraedrVolumeRatio() throws CustomException {
        TetraServiceImpl  tetraService = new TetraServiceImpl();
        Point point = new Point(1,2,3);
        Tetraedr tetredr = TetraFactory.createTetraedr(new Point(5,4,2),4,5);
        double actualVolumeRatio = tetraService.tetraedrVolumeRatio(tetredr,point);
        double expectedVolumeRatio = 1.78;
        assertEquals(actualVolumeRatio,expectedVolumeRatio,0.01);
    }

    @Test
    public void isBaseOnCoordinatePlane() {
        TetraServiceImpl tetraService = new TetraServiceImpl();
        Point point = new Point(0,4,0);
        Tetraedr tetredr = TetraFactory.createTetraedr(point,4,5);
        boolean isBaseOnCoordinatePlane = tetraService.isBaseOnCoordinatePlane(tetredr);
        assertTrue(isBaseOnCoordinatePlane);
    }

    @Test
    public void tetraedrArea() {
        TetraServiceImpl  tetraService = new TetraServiceImpl();
        Point point = new Point(1,2,3);
        Tetraedr tetredr = TetraFactory.createTetraedr(point,4,5);
        double actualArea = tetraService.tetraedrArea(tetredr);
        double expectedArea = 27.71;
        assertEquals(actualArea,expectedArea,0.01);
    }

}
