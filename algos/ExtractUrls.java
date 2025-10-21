package algos;

import java.io.*;
import java.util.regex.*;

public class ExtractUrls {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("webpage-writer\\web.html"))) {

            // Regex to match href URLs
            Pattern pattern = Pattern.compile("href\\s*=\\s*[\"'](https?://[^\"'>\\s]+)[\"']", Pattern.CASE_INSENSITIVE);

            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    System.out.println(matcher.group(1)); // print the URL
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

