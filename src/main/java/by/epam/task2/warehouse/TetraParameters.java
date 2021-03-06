package by.epam.task2.warehouse;

public class TetraParameters {

    private double area;
    private double volume;

    public TetraParameters(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TetraParameters that = (TetraParameters) o;
        return Double.compare(that.area, area) == 0 && Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        double area = this.area;
        double volume = this.volume;
        hash = hash + Double.hashCode(area) + Double.hashCode(volume);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TetraParameters{");
        builder.append("Area=").append(area);
        builder.append(", volume=").append(volume);
        builder.append("}");
        return builder.toString();
    }
}
