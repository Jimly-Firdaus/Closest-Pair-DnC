package type;

public class Point {
    protected double[] vector;
    protected int dimension;

    public Point (int d) {
        this.dimension = d;
        this.vector = new double[this.dimension];
    }

    public double[] getVector () {
        return this.vector;
    }

    public int getDimension () {
        return this.dimension;
    }

    public void printVector () {
        System.out.print("(");
        for (int i = 0; i < this.vector.length; i++) {
            System.out.print(this.vector[i]);
            if (i == this.vector.length - 1) {
                System.out.print("");
            } else {
                System.out.print(", ");
            }
        }
        System.out.print(")\n");
    }

}