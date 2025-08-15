import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class scraper {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try{
         String link = ("https://en.wikipedia.org/wiki/Artificial_intelligence");
         URL url = new URL(link);
         InputStreamReader in = new InputStreamReader(url.openStream());
         BufferedReader inp = new BufferedReader(in);
         BufferedWriter out = new BufferedWriter(new FileWriter("web.html"));
        String content;
        while((content = inp.readLine()) != null){
            out.write(content);
            out.newLine();
        }
          in.close();
          out.close();  
         }
           catch (IOException e) {
            e.printStackTrace();
        }
       
    }
}
