import java.util.Random;

import java.util.Arrays;
import type.*;

public class Points {
    private Point[] points;
    private int size;

    private final int min = -100;
    private final int max = 100;

    public static int divideAndConquer = 0;
    public static int bruteForce = 0;

    public static int getTotalDivideConquer () {
        return divideAndConquer;
    }

    public static int getTotalBruteForce () {
        return bruteForce;
    }

    Random random = new Random();

    public Points(int size, int dimension) {
        this.size = size;
        this.points = new Point[this.size];
        for (int i = 0; i < this.size; i++) {
            this.points[i] = new Point(dimension);
            for (int j = 0; j < dimension; j++) {
                this.points[i].getVector()[j] = random.nextDouble(max + 1) - min;
            }
        }

    }

    public Point[] getPoints() {
        return this.points;
    }

    public int getSize() {
        return this.size;
    }

    private static double euclidDistance (Point p1, Point p2, boolean div_conquer) {
        double distance = 0;
        for (int i = 0; i < p1.getDimension(); i++) {
            double diff = p1.getVector()[i] - p2.getVector()[i];
            distance += Math.pow(diff, 2);
        }
        if (div_conquer) {
            divideAndConquer++;
        } else {
            bruteForce++;
        }

        return Math.sqrt(distance);
    }

    public ClosestPair divideAndConquer(Point[] points, int arr_size, int axis, int max_dimension) {
        if (arr_size == 2) {
            ClosestPair res = new ClosestPair();
            res.setPair(points);
            res.setDistance(euclidDistance(points[0], points[1], true));
            divideAndConquer++;
            return res;
        } 
        else if (arr_size == 3) {
            ClosestPair res = new ClosestPair();
            Point[] temp = new Point[2];
            double d1 = euclidDistance(points[0], points[1], true);
            double d2 = euclidDistance(points[1], points[2], true);
            double d3 = euclidDistance(points[0], points[2], true);
            divideAndConquer += 2; 
            double minDist = Math.min(Math.min(d1, d2), d3);
            if (minDist == d1) {
                temp[0] = points[0];
                temp[1] = points[1];
                res.setDistance(d1);
            }
            else if (minDist == d2) {
                temp[0] = points[1];
                temp[1] = points[2];
                res.setDistance(d2);
            } else {
                temp[0] = points[0];
                temp[1] = points[2];
                res.setDistance(d3);
            }
            res.setPair(temp);

            return res;
        }
        else {
            axis = axis + 1 < max_dimension - 1 ? axis + 1 : 0;
            QuickSort.quicksort(points, axis);
            int start_idx = 0;
            int end_idx = arr_size % 2 == 0 
                ? arr_size / 2 
                : arr_size / 2 + 1;
            Point[] setOfPoints_1 = Arrays.copyOfRange(points, start_idx, end_idx);
            Point[] setOfPoints_2 = Arrays.copyOfRange(points, end_idx, arr_size);
            ClosestPair res_1 = divideAndConquer(setOfPoints_1, arr_size/2, axis, max_dimension);
            ClosestPair res_2 = divideAndConquer(setOfPoints_2, arr_size/2, axis, max_dimension);

            ClosestPair res = new ClosestPair();
            if (res_1.getDistance() > res_2.getDistance()) {
                res = res_2;
            } else {
                res = res_1;
            }
            double distanceInStrip = Double.MAX_VALUE;
            for (int i = 0; i < arr_size; i++) {
                for (int j = i + 1; j < arr_size; j++) {
                    for (int k = 0; k < points[i].getDimension(); k++) {
                        if (Math.abs(points[i].getVector()[k] - points[j].getVector()[k]) > res.getDistance()) {
                            
                        } else {
                            distanceInStrip = euclidDistance(points[i], points[j], true);
                            if (distanceInStrip < res.getDistance()) {
                                Point[] temp = new Point[2];
                                temp[0] = points[i];
                                temp[1] = points[j];
                                res.setPair(temp);
                                res.setDistance(distanceInStrip);
                            }
                        }
                    }
                }
            }
            return res;
        }

    }

    public ClosestPair bruteForce (Point[] points) {
        double shortestDistance = Double.MAX_VALUE;
        ClosestPair res = new ClosestPair();
        Point[] temp = new Point[2];
        
        // Compare each pair of points
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = euclidDistance(points[i], points[j], false);
                bruteForce++;
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    temp[0] = points[i];
                    temp[1] = points[j];
                }
            }
        }
        res.setPair(temp);
        res.setDistance(shortestDistance);
        return res;
    }
}

