package by.epam.task3.entity;

public class Point {

    private double x;
    private double y;
    private double z;

    public Point(){}

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0 && Double.compare(point.z, z) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        double x = this.x;
        double y = this.y;
        double z = this.z;
        hash = hash + Double.hashCode(x) + Double.hashCode(y) + Double.hashCode(z);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Point{x=");
        builder.append(x).append(", y=");
        builder.append(y).append(", z=");
        builder.append(z).append("}");
        return builder.toString();
    }
}
