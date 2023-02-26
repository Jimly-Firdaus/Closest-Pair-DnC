import type.ClosestPair;
import java.time.Instant;
import java.time.Duration;
import java.util.Scanner;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.InterruptedException;
import java.io.*;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // system specs
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        String osName = osBean.getName();
        String osArch = osBean.getArch();
        String osVersion = osBean.getVersion();
        int availableProcessors = osBean.getAvailableProcessors();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("Operating System: " + osName + " " + osVersion + " " + osArch);
        System.out.println("Available Processors: " + availableProcessors);
        System.out.println("Total Memory: " + totalMemory / 1024 / 1024 + " MB");

        System.out.println("\n=============================\n");
        // prompt for input size & dimension
        System.out.print("Input total points: ");
        int size = scan.nextInt();
        System.out.print("Dimension per point: ");
        int dimension = scan.nextInt();
        
        Points points = new Points(size, dimension);
        Points points2 = points;
        Points points3 = points2;
        ClosestPair ans, ans_;
        
        // Divide & Conquer
        Instant start = Instant.now();
        ans = points.divideAndConquer(points.getPoints(), size, 0, dimension);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);

        System.out.println("\n\nDivide & Conquer execution time: " + timeElapsed.toSeconds() + " seconds (" + timeElapsed.toSeconds() + " millis)");
        System.out.println("Divide & Conquer: " + ans.getDistance());
        System.out.println("Total count: " + Points.getTotalDivideConquer());
        System.out.println("\n=============================\n");

        // Brute Force
        Instant start_ = Instant.now();
        ans_ = points2.bruteForce(points2.getPoints());
        Instant end_ = Instant.now();
        Duration timeElapsed_ = Duration.between(start_, end_);

        System.out.println("Brute Force execution time: " + timeElapsed_.toSeconds() + " seconds (" + timeElapsed_.toSeconds() + " millis)");
        System.out.println("Brute Force: " + ans_.getDistance());
        System.out.println("Total count: " + Points.getTotalBruteForce());

        // visualizing 3D points
        if (points.getPoints()[0].getDimension() == 3) {
            OutputCSV.outputCSVHandler(points3, ans);

            // call the Python script to visualize the data
            try {
                ProcessBuilder pb = new ProcessBuilder("python", "../src/visualizer.py");
                pb.redirectErrorStream(true);
                Process p = pb.start();
                // read the output of the process (to catch errors)
                try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                }

                int exitCode = p.waitFor();
                if (exitCode != 0) {
                    System.err.println("Python script exited with error code " + exitCode);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
