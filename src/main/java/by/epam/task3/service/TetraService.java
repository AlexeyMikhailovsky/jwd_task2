package by.epam.task3.service;

import by.epam.task3.entity.Point;
import by.epam.task3.entity.Tetraedr;
import by.epam.task3.exception.CustomException;

public interface TetraService {

    double tetraedrArea(Tetraedr tetra);

    double tetraedrVolume(Tetraedr tetra);

    double tetraedrVolumeRatio(Tetraedr tetra, Point point) throws CustomException;

    boolean isTetraedr(double radius, double height);

    boolean isBaseOnCoordinatePlane(Tetraedr tetra);

}
