package by.epam.task3.entity;

import by.epam.task3.observer.TetraEvent;
import by.epam.task3.observer.TetraObservable;
import by.epam.task3.observer.TetraObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tetraedr implements TetraObservable {

    private static Logger logger = LogManager.getLogger();
    private Point center;
    private double edge;
    private double height;
    private long tetraId;
    private List<TetraObserver> observers = new ArrayList<>();

    public Tetraedr() {
    }

    public Tetraedr(Point center, double edge, double height) {
        this.center = center;
        this.edge = edge;
        this.height = height;
    }

    @Override
    public void attach(TetraObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(TetraObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        TetraEvent event = new TetraEvent(this);
        for (TetraObserver observer : observers) {
            observer.updateParameters(event);
        }
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        Tetraedr.logger = logger;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public long getTetraId() {
        return tetraId;
    }

    public void setTetraId(long tetraId) {
        this.tetraId = tetraId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tetrahedron{");
        builder.append("center=").append(center);
        builder.append(", edge=").append(edge);
        builder.append(", height=").append(height);
        builder.append(", tetraId=").append(tetraId);
        builder.append('}');
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetraedr tetraedr = (Tetraedr) o;
        return Double.compare(tetraedr.edge, edge) == 0 &&
                Double.compare(tetraedr.height, height) == 0 &&
                tetraId == tetraedr.tetraId && Objects.equals(center, tetraedr.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, edge, height, tetraId, observers);
    }
}
