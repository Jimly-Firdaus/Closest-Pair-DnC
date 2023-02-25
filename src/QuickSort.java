import type.*;

public class QuickSort {
    public static void quicksort(Point[] points, int axis) {
        if (points == null || points.length == 0) {
            return;
        }
        sort(points, 0, points.length - 1, axis);
    }
    
    private static void sort(Point[] points, int low, int high, int axis) {
        if (low >= high) {
            return;
        }
        int partitionIndex = partition(points, low, high, axis);
        sort(points, low, partitionIndex - 1, axis);
        sort(points, partitionIndex + 1, high, axis);
    }
    
    private static int partition(Point[] points, int low, int high, int axis) {
        double pivot = points[high].getVector()[axis];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (points[j].getVector()[axis] <= pivot) {
                i++;
                swap(points, i, j);
            }
        }
        swap(points, i + 1, high);
        return i + 1;
    }
    
    private static void swap(Point[] points, int i, int j) {
        Point temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}

