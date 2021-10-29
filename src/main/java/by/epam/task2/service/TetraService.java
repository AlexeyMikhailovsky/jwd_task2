package by.epam.task2.service;

import by.epam.task2.entity.Point;
import by.epam.task2.entity.Tetraedr;
import by.epam.task2.exception.CustomException;

public interface TetraService {

    double tetraedrArea(Tetraedr tetra);

    double tetraedrVolume(Tetraedr tetra);

    double tetraedrVolumeRatio(Tetraedr tetra, Point point) throws CustomException;

    boolean isTetraedr(double radius, double height);

    boolean isBaseOnCoordinatePlane(Tetraedr tetra);

}
