package exercise;

// BEGIN
class Cottage implements Home {
    private double livingArea;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.livingArea = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return this.livingArea;
    }

    @Override
    public int compareTo(Home home) {
        double thisArea = this.getArea();
        double compareArea = home.getArea();
        return Double.compare(thisArea, compareArea);
    }

    @Override
    public String toString() {
        return this.floorCount + " этажный коттедж площадью " + this.getArea() + " метров";
    }
}
// END
