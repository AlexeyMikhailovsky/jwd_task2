package by.epam.task3.entity;

import by.epam.task3.observer.TetraEvent;
import by.epam.task3.observer.TetraObservable;
import by.epam.task3.observer.TetraObserver;
import by.epam.task3.util.GeneratorId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tetraedr implements TetraObservable {

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
        this.tetraId = GeneratorId.generete();
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
        if (!observers.isEmpty()) {
            for (TetraObserver observer : observers) {
                observer.updateParameters(event);
            }
        }
    }

    public Point getCenter() {
        return center;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
        notifyObserver();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        notifyObserver();
    }

    public long getTetraId() {
        return tetraId;
    }

    public void setTetraId(long tetraId) {
        this.tetraId = tetraId;
        notifyObserver();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tetraedr{");
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
        int hash = 1;
        double edge = this.edge;
        double height = this.height;
        hash = hash + Double.hashCode(edge) + Double.hashCode(height);
        return hash;
    }
}
