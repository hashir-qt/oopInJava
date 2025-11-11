package algos;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CountryInfo {
    String name;
    double surfaceArea;
    int indepYear;
    double population;
    double lifeExpectancy;

    public CountryInfo(String line) {
        try {
            String[] parts = line.split("\t");

            this.name = parts[1];
            this.surfaceArea = parseDouble(parts[4]);
            this.indepYear = parseInt(parts[5]);
            this.population = parseDouble(parts[6]);
            this.lifeExpectancy = parseDouble(parts[7]);

        } catch (Exception e) {
            System.out.println("Error parsing line: " + line);
        }
    }

    private int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0; 
        }
    }

    // Helper to safely parse double
    private double parseDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return 0.0; 
        }
    }

    public static double colSum(ArrayList<CountryInfo> ciList, int colIndex) {
        double sum = 0;
        for (CountryInfo c : ciList) {
            switch (colIndex) {
                case 1:
                 sum += c.surfaceArea;       
                case 2:
                 sum += c.population;        
                case 3:
                 sum += c.lifeExpectancy;    
                default:
                 System.out.println("Invalid column index!");
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String path = "D:\\javasem2\\algos\\countryinfo.txt"; 
        File file = new File(path);
        ArrayList<CountryInfo> ciList = new ArrayList<>();

        try {
            Scanner sc = new Scanner(file);
            if (sc.hasNextLine()) sc.nextLine(); 

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                ciList.add(new CountryInfo(line));
            }
            sc.close();

            double surfaceAreaSum = CountryInfo.colSum(ciList, 1);
            double populationSum = CountryInfo.colSum(ciList, 2);

            double totalLifeExpectancy = CountryInfo.colSum(ciList, 3);
            double averageLifeExpectancy = totalLifeExpectancy / ciList.size();

            System.out.println("Total Countries Loaded: " + ciList.size());
            System.out.println("Sum of Surface Areas: " + surfaceAreaSum);
            System.out.println("Sum of Populations: " + populationSum);
            System.out.println("Average Life Expectancy: " + averageLifeExpectancy);

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
