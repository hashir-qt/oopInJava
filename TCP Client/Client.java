import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        // create a socket to connect to the server running on localhost at port number 9090
        Socket socket = new Socket("localhost", 9090);
        
        // Setup output stream to send data to the server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        // Setup input stream to receive data from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Send message to the server
        String message = "test";
        out.println(message);
        while (!message.equals("quit")) {
            message = sc.nextLine();
            out.println(message);
            // Receive response from the server
            if (message.equals("dir")) {
                String response;
                while ((response = in.readLine()) != null) {
                    System.out.println(response);
                    if (response.equals("get: ")) {
                        break;
                    }
                }
                message = sc.nextLine();
                out.println(message);
                if (message.equals("get sales.txt")) {
                    // Print file contents until "end_of_file"
                    while ((response = in.readLine()) != null) {
                        if (response.equals("end_of_file")) {
                            break;
                        }
                        System.out.println(response);
                    }
                }
                if (message.equals("get names.txt")) {
                    // Print file contents until "end_of_file"
                    while ((response = in.readLine()) != null) {
                        if (response.equals("end_of_file")) {
                            break;
                        }
                        System.out.println(response);
                    }
                }
                if (message.equals("get words.txt")) {
                    // Print file contents until "end_of_file"
                    while ((response = in.readLine()) != null) {
                        if (response.equals("end_of_file")) {
                            break;
                        }
                        System.out.println(response);
                    }
                }
                if (message.equals("get test.txt")) {
                    // Print file contents until "end_of_file"
                    while ((response = in.readLine()) != null) {
                        if (response.equals("end_of_file")) {
                            break;
                        }
                        System.out.println(response);
                    }
                }
                if (message.equals("get numbers.txt")) {
                    // Print file contents until "end_of_file"
                    while ((response = in.readLine()) != null) {
                        if (response.equals("end_of_file")) {
                            break;
                        }
                        System.out.println(response);
                    }
                }
            } else {
                String response = in.readLine();
                System.out.println("Server says: " + response);
            }
            if(message.equals("quit")) {
                // Receive response from the server
                String response = in.readLine();
                System.out.println("Server says: " + response);
                socket.close();
            }   // Close the socket
        }  
    sc.close();                                                                                                                                                  
  }
}