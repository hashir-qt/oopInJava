import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class new1 {
    public static void main(String[] args) {
        String filepath = "sales.txt";
        File f1 = new File(filepath);

        try {
            Scanner sc = new Scanner(f1);
            BufferedWriter out = new BufferedWriter(new FileWriter("file2.html"));

            // Start HTML document
            out.write("<!DOCTYPE html>");
            out.newLine();
            out.write("<html>");
            out.newLine();
            out.write("<head><title>Sales Report</title></head>");
            out.newLine();
            out.write("<body>");
            out.newLine();
            out.write("<h1>Sales Report</h1>");
            out.newLine();
            out.write("<table border='1' cellspacing='0' cellpadding='5'>");
            out.newLine();

            boolean isFirstLine = true;

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue; // skip empty lines

                String[] columns = line.split("\t");

                if (isFirstLine) {
                    // Write table headers
                    out.write("<thead><tr>");
                    for (String col : columns) {
                        out.write("<th>" + col + "</th>");
                    }
                    out.write("</tr></thead>");
                    out.newLine();
                    out.write("<tbody>");
                    out.newLine();
                    isFirstLine = false;
                } else {
                    // Write data rows
                    out.write("<tr>");
                    for (String col : columns) {
                        out.write("<td>" + col + "</td>");
                    }
                    out.write("</tr>");
                    out.newLine();
                }
            }

            // Close tags
            out.write("</tbody>");
            out.newLine();
            out.write("</table>");
            out.newLine();
            out.write("</body>");
            out.newLine();
            out.write("</html>");

            // Cleanup
            out.close();
            sc.close();

            System.out.println("HTML file created successfully as file.html");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
