package exercise;

// BEGIN
class Flat implements Home {
    private double livingArea;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.livingArea = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return this.livingArea + this.balconyArea;
    }

    @Override
    public int compareTo(Home home) {
        double thisArea = this.getArea();
        double compareArea = home.getArea();
        return Double.compare(thisArea, compareArea);
    }

    @Override
    public String toString() {
        return "Квартира площадью " + this.getArea() + " метров на " + this.floor + " этаже";
    }
}
// END
