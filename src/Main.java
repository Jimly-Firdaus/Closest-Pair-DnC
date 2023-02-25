import type.ClosestPair;

import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int size = scan.nextInt();
        Points points = new Points(size, 100);
        Points points2 = points;
        ClosestPair ans, ans_;
        ans = points.divideAndConquer(points.getPoints(), size, 0, 100);
        System.out.println("Divide & Conquer: " + ans.getDistance());
        ans.getPair()[0].printVector();
        ans.getPair()[1].printVector();
        System.out.println("Total count: " + points.getTotalDivideConquer());
        System.out.println("\n=============================\n\n");
        ans_ = points2.bruteForce(points2.getPoints());
        System.out.println("Brute Force: " + ans_.getDistance());
        ans_.getPair()[0].printVector();
        ans_.getPair()[1].printVector();
        System.out.println("Total count: " + points2.getTotalBruteForce());
    }


}

