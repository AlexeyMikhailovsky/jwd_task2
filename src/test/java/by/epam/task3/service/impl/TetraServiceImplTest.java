package by.epam.task3.service.impl;

import by.epam.task3.entity.Point;
import by.epam.task3.entity.Tetraedr;
import by.epam.task3.exception.CustomException;
import by.epam.task3.factory.TetraFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TetraServiceImplTest {

    @Test
    public void isTetraedr() {
        TetraServiceImpl  tetraService = new TetraServiceImpl();
        boolean isTetraedr = tetraService.isTetraedr(3.4,6.4);
        assertTrue(isTetraedr);
    }

    @Test
    public void tetraedrVolume() {
        TetraServiceImpl  tetraService = new TetraServiceImpl();
        Point point = new Point(5,6,7);
        Tetraedr tetredr = TetraFactory.createTetraedr(point,8,9);
        double actualVolume = tetraService.tetraedrVolume(tetredr);
        double expectedVolume = 60.34;
        assertEquals(actualVolume,expectedVolume,0.01);
    }

    @Test
    public void tetraedrVolumeRatio() throws CustomException {
        TetraServiceImpl  tetraService = new TetraServiceImpl();
        Point point = new Point(2,1,1);
        Tetraedr tetredr = TetraFactory.createTetraedr(new Point(2,3,5),4,5);
        double actualVolumeRatio = tetraService.tetraedrVolumeRatio(tetredr,point);
        double expectedVolumeRatio = 1.78;
        assertEquals(actualVolumeRatio,expectedVolumeRatio,0.01);
    }

    @Test
    public void isBaseOnCoordinatePlane() {
        TetraServiceImpl tetraService = new TetraServiceImpl();
        Point point = new Point(9,0,0);
        Tetraedr tetredr = TetraFactory.createTetraedr(point,2,3);
        boolean isBaseOnCoordinatePlane = tetraService.isBaseOnCoordinatePlane(tetredr);
        assertTrue(isBaseOnCoordinatePlane);
    }

    @Test
    public void tetraedrArea() {
        TetraServiceImpl  tetraService = new TetraServiceImpl();
        Point point = new Point(5,6,7);
        Tetraedr tetredr = TetraFactory.createTetraedr(point,8,9);
        double actualArea = tetraService.tetraedrArea(tetredr);
        double expectedArea = 110.85;
        assertEquals(actualArea,expectedArea,0.01);
    }

}
