package type;

public class ClosestPair {
    private Point[] pair;
    private double distance;

    public void setPair (Point[] pair) {
        this.pair = pair;
    }

    public void setDistance (double d) {
        this.distance = d;
    }

    public Point[] getPair () {
        return this.pair;
    }

    public double getDistance () {
        return this.distance;
    }
}
