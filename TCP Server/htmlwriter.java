
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class htmlwriter {
    public static void main(String[] args) {
        String filepath = "sales.txt";
        File f1 = new File(filepath);
        try{
            Scanner sc = new Scanner(f1);
        //     while(sc.hasNextLine()){
        //        String Line = sc.nextLine();
        //        System.out.println(Line);
        //     }
        //    sc.close();
          BufferedWriter out = new BufferedWriter(new FileWriter("file.html"));
          out.write("<!DOCTYPE html>\r\n" + //
                            "<html lang=\"en\">\r\n" + //
                            "<head>\r\n" + //
                            "    <meta charset=\"UTF-8\">\r\n" + //
                            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                            "    <title>Document</title>\r\n" + //
                            "</head>\r\n" + //
                            "<body>\r\n" + //
                            "<h1>Sales Report</h1>\r\n"+
                              "<table border='1' cellspacing='0' cellpadding='5'>"
                            );
      
          while(sc.hasNextLine()){
             String Line = sc.nextLine();
             String[] columns = Line.split("\t");
                out.write("<tr>");
                    for (int i = 0; i < columns.length; i++) {
                        out.write("<td>" + columns[i] + "</td>");
                    }
                    out.write("</tr>");
                    out.newLine();
        }
           out.write("</tbody>\n\r" );
            out.newLine();
            out.write("</table>");
            out.newLine();
            out.write("</body>");
            out.newLine();
            out.write("</html>");
          sc.close();
          out.close(); 
           
        }
        
        catch(IOException fnfe){
            System.out.println("File Not found");
        }
        
    }
}
