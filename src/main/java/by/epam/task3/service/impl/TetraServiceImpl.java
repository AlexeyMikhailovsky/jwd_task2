package by.epam.task3.service.impl;

import by.epam.task3.entity.Point;
import by.epam.task3.entity.Tetraedr;
import by.epam.task3.exception.CustomException;
import by.epam.task3.service.TetraService;

public class TetraServiceImpl implements TetraService {

    @Override
    public double tetraedrArea(Tetraedr tetra) {
        double scale = Math.pow(10, 2);
        return Math.round(scale * Math.sqrt(3)* Math.pow(tetra.getEdge(),2))/scale;
    }

    @Override
    public double tetraedrVolume(Tetraedr tetra) {
        double scale = Math.pow(10, 2);
        double tetrahedronArea = Math.sqrt(3)* Math.pow(tetra.getEdge(),2);
        return Math.round(scale * 1/3 * tetrahedronArea * tetra.getHeight())/scale;
    }

    @Override
    public double tetraedrVolumeRatio(Tetraedr tetra, Point point) throws CustomException {
        double scale = Math.pow(10, 2);
        if (point.getZ() <= tetra.getCenter().getZ() || point.getZ() >= tetra.getCenter().getZ() + tetra.getHeight()) {
            throw new CustomException(" No sections from point " + point.toString());
        } else {
            double secondHeight = point.getZ() - tetra.getCenter().getZ();
            double firstHeight = tetra.getHeight() - secondHeight;
            double firstEdge = firstHeight * tetra.getEdge() / tetra.getHeight();
            double firstTetraVolume = tetraedrVolume(new Tetraedr(tetra.getCenter(),firstHeight,firstEdge));
            double secondConeVolume = tetraedrVolume(tetra) - firstTetraVolume;
            return Math.round(scale * firstTetraVolume / secondConeVolume)/scale;
        }
    }

    @Override
    public boolean isTetraedr( double edge, double height) {
        return edge > 0 && height > 0;
    }

    @Override
    public boolean isBaseOnCoordinatePlane(Tetraedr tetra) {
        return tetra.getCenter().getZ() == 0;
    }

}
