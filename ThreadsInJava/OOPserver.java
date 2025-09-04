package ThreadsInJava;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class OOPserver {
    ServerSocket serverSocket;
    int c = 0;                  // message counter
 int LIMIT = 1000;     // max number of messages before shutdown

    public void startServer(int portNumber) {
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Server is running and waiting for clients...");

            while (c < LIMIT) { // bounded loop
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Each client handled in its own thread
                ClientHandler handler = new ClientHandler(clientSocket, this);
                handler.start();
                c++;
            }

            System.out.println("Limit reached. Closing server...");
            quitServer();

        } catch (IOException ime) {
            System.out.println("IO exception while starting server");
        }
    }

    // increase counter safely
    public synchronized void incrementCounter() {
        c++;
    }

    public void quitServer() {
        try {
            serverSocket.close();
        } catch (IOException ime) {
            System.out.println("Error closing server socket");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        OOPserver server = new OOPserver();
        System.out.print("Enter PortNumber: ");
        int portNum = sc.nextInt();
        server.startServer(portNum);
        sc.close();
    }
}

class ClientHandler extends Thread {
    Socket clientSocket;
    DataInputStream dis;
    DataOutputStream dos;
    OOPserver server; 

    public ClientHandler(Socket socket, OOPserver server) {
        this.clientSocket = socket;
        this.server = server;
        try {
            dis = new DataInputStream(clientSocket.getInputStream());
            dos = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Error initializing client handler");
        }
    }

    // send message to client
    public void sendMessage(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException ime) {
            System.out.println("IO exception while sending message");
        }
    }

    // receive message from client
    public String recieveMessage() {
        try {
            return dis.readUTF();
        } catch (IOException ime) {
            System.out.println("IO exception while receiving message");
        }
        return null;
    }

    // close client connection
    public void quitClient() {
        try {
            clientSocket.close();
        } catch (IOException ime) {
            System.out.println("Error closing client socket");
        }
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = recieveMessage()) != null) {
                System.out.println("Client says: " + message);
                server.incrementCounter(); // count each message

                if (message.equalsIgnoreCase("quit")) {
                    System.out.println("Client disconnected: " + clientSocket);
                    quitClient();
                    break;
                }

                // Reply back only to this client
                sendMessage("Server received: " + message);
            }
        } catch (Exception e) {
            System.out.println("Connection closed with client: " + clientSocket);
        }
    }
}
