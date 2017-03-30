package classifiers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "C:/Users/Asuss/workspace/classifiers/wine.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] wine = line.split(cvsSplitBy);
                
                System.out.println("Wine [class= " + wine[0] + 
                					" , alcohol=" + wine[1] +
                					" , malic acid=" + wine[2] + 
                					" , ash=" + wine[3] +		
                					" , alcalinity of ash=" + wine[4] +
                					" , magnesium=" + wine[5] +
                					" , Total phenols=" + wine[6] +
                					" , flavanoids=" + wine[7] +
                					" , nonflavanoid phenols=" + wine[8] +
                					" , proanthocyanins=" + wine[9] +
                					" , color intensity=" + wine[10] +
                					" , hue=" + wine[11] +
                					" , od280/od315 of diluted wines=" + wine[12] +
                					" , proline=" + wine[13] 
                							+ "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}