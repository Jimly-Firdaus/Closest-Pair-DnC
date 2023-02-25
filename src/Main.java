import type.ClosestPair;
import java.time.Instant;
import java.time.Duration;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Total points: ");
        int size = scan.nextInt();
        System.out.print("Dimension per point: ");
        int dimension = scan.nextInt();
        
        Points points = new Points(size, dimension);
        Points points2 = points;
        ClosestPair ans, ans_;
        Instant start = Instant.now();
        ans = points.divideAndConquer(points.getPoints(), size, 0, dimension);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Divide & Conquer exec time: " + timeElapsed.toMillis() + " milliseconds");
        System.out.println("Divide & Conquer: " + ans.getDistance());
        System.out.println("Total count: " + Points.getTotalDivideConquer());
        System.out.println("\n=============================\n");
        Instant start_ = Instant.now();
        ans_ = points2.bruteForce(points2.getPoints());
        Instant end_ = Instant.now();
        Duration timeElapsed_ = Duration.between(start_, end_);
        System.out.println("Brute Force exec time: " + timeElapsed_.toMillis() + " milliseconds");
        System.out.println("Brute Force: " + ans_.getDistance());
        System.out.println("Total count: " + Points.getTotalBruteForce());
    }


}

