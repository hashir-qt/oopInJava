import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String args[]) throws IOException 
    {
        
        // create a server socket on port number 9090
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server is running and waiting for client connection...");

        // Accept incoming client connection
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        // Setup input and output streams for communication with the client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Read message from client
        String message = in.readLine();
           while (!message.equals("quit")) {
               message = in.readLine();
               System.out.println("Client says: " + message);
               out.println("type quit to exit");

               
               if(message.equals("dir")) {
                out.println("1. names.txt");
                out.println("2. numbers.txt");
                out.println("3. sales.txt");
                out.println("4. test.txt");
                out.println("5. words.txt");
                out.println("get: ");
                message = in.readLine();
                if(message.equals("get sales.txt")) {
                    File f1 = new File("sales.txt");
                    Scanner sc = new Scanner(f1);
                    while(sc.hasNextLine()) {
                        String line = sc.nextLine();
                        out.println(line);   
                    }
                    out.println("end_of_file");
                    sc.close();
                }
                if(message.equals("get names.txt")) {
                    File f1 = new File("names.txt");
                    Scanner sc = new Scanner(f1);
                    while(sc.hasNextLine()) {
                        String line = sc.nextLine();
                        out.println(line);   
                    }
                    out.println("end_of_file");
                    sc.close();
                }
                if(message.equals("get words.txt")) {
                    File f1 = new File("words.txt");
                    Scanner sc = new Scanner(f1);
                    while(sc.hasNextLine()) {
                        String line = sc.nextLine();
                        out.println(line);   
                    }
                    out.println("end_of_file");
                    sc.close();
                }
                if(message.equals("get numbers.txt")) {
                    File f1 = new File("numbers.txt");
                    Scanner sc = new Scanner(f1);
                    while(sc.hasNextLine()) {
                        String line = sc.nextLine();
                        out.println(line);   
                    }
                    out.println("end_of_file");
                    sc.close();
                }
                if(message.equals("get test.txt")) {
                    File f1 = new File("test.txt");
                    Scanner sc = new Scanner(f1);
                    while(sc.hasNextLine()) {
                        String line = sc.nextLine();
                        out.println(line);   
                    }
                    out.println("end_of_file");
                    sc.close();
                }
               
            }
        
             
            if(message.equals("quit")) {
               out.println("Exiting the server...");
               break;
                }
        }
        System.out.println("Exiting the server...");

        // Send response to the client
        
        // Close the client socket
        clientSocket.close();
        // Close the server socket
        serverSocket.close();
    }
}
