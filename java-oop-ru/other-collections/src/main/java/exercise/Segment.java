package exercise;

// BEGIN
class Segment {
    private Point point1;
    private Point point2;
    private Point midPoint;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        int midX = (point1.getX() + point2.getX()) / 2;
        int midY = (point1.getY() + point2.getY()) / 2;
        this.midPoint = new Point(midX, midY);
    }

    public Point getBeginPoint() {
        return this.point1;
    }

    public Point getEndPoint() {
        return this.point2;
    }

    public Point getMidPoint() {
        return this.midPoint;
    }
}
// END
