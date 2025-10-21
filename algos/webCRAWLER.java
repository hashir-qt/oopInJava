package algos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class webCRAWLER {

    public static void main(String[] args) {
        ArrayList<String> savedURLs = new ArrayList<>();
        ArrayList<String> visited = new ArrayList<>();

        // Starting URL(s)
        savedURLs.add("https://openai.github.io/openai-agents-python/ref/exceptions/");

        int counter = 0;

        // Keep crawling while there are URLs left to visit
        while (!savedURLs.isEmpty() && visited.size() < 10) { // limit to 10 pages for safety
            String currentURL = savedURLs.remove(0);

            // Skip if already visited
            if (visited.contains(currentURL)) {
                continue;
            }

            visited.add(currentURL);
            String filename = "webpage" + counter + ".html";

            try {
                System.out.println("Downloading: " + currentURL);
                URL url = new URL(currentURL);
                InputStreamReader in = new InputStreamReader(url.openStream());
                BufferedReader reader = new BufferedReader(in);
                BufferedWriter writer = new BufferedWriter(new FileWriter("savedpages/" + filename));

                String line;
                Pattern pattern = Pattern.compile("href\\s*=\\s*\"(https?://[^\"]+)\"", Pattern.CASE_INSENSITIVE);

                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();

                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        String foundURL = matcher.group(1);
                        // Add only new links
                        if (!savedURLs.contains(foundURL) && !visited.contains(foundURL)) {
                            savedURLs.add(foundURL);
                        }
                    }
                }

                reader.close();
                writer.close();
                counter++;

            } catch (IOException e) {
                System.out.println("Error downloading " + currentURL + ": " + e.getMessage());
            }

            System.out.println("Total links collected: " + savedURLs.size());
        }

        System.out.println("\nCrawling complete!");
        System.out.println("Pages visited: " + visited.size());
    }
}
