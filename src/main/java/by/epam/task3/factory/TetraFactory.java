package by.epam.task3.factory;

import by.epam.task3.entity.Point;
import by.epam.task3.entity.Tetraedr;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.stream.Collectors;

public class TetraFactory {

    private static Logger logger = LogManager.getLogger();

    public static Tetraedr createTetra(Point point, double edge, double height)  {
        Tetraedr tetra = new Tetraedr(point,edge,height);
        return tetra;
    }

    public static Tetraedr createTetra(double[] parameters) {
        Point points = new Point(parameters[0], parameters[1], parameters[2]);
        double edge = parameters[3];
        double height = parameters[4];
        return createTetra(points, edge, height);
    }

    public static List<Tetraedr> createTetraList(List<double[]> coordinates) {
        List<Tetraedr> tetraeders;
        tetraeders = coordinates.stream()
                .map(arr -> createTetra(arr))
                .filter(e -> e != null)
                .collect(Collectors.toList());
        return tetraeders;
    }
}