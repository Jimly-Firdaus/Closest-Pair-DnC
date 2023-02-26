import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import type.ClosestPair;

public class OutputCSV {
    public static void outputCSVHandler (Points point, ClosestPair result_pair) throws IOException {
        String fileName = "result";
        String content = "";
        for (int i = 0; i < point.getSize(); i++) {
            if (Arrays.equals(point.getPoints()[i].getVector(), result_pair.getPair()[0].getVector()) || Arrays.equals(point.getPoints()[i].getVector(), result_pair.getPair()[1].getVector())) {
                content += "&" + point.getPoints()[i].getVector()[0] + "," + point.getPoints()[i].getVector()[1] + "," + point.getPoints()[i].getVector()[2] + "\n";
            } else {
                content += point.getPoints()[i].getVector()[0] + "," + point.getPoints()[i].getVector()[1] + "," + point.getPoints()[i].getVector()[2] + "\n";
            }
        }
        FileWriter writer = new FileWriter ("../bin/" + fileName + ".csv");
        writer.write(content);
        writer.close();
    }    
}
