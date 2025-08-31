import java.io.*;
import java.net.*;
import java.util.Scanner;

public class OOPserver {
    ServerSocket serverSocket;
    Socket clientSocket;
    DataInputStream dis;
    DataOutputStream dos;

    public void startServer(int portNumber) {
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Server is running and waiting for client connection...");
        } catch (IOException ime) {
            System.out.println("IO exception while starting server");
        }
    }

    public void clientConnect() {
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Client connected!");
            // Initialize data streams once the client is connected
            dis = new DataInputStream(clientSocket.getInputStream());
            dos = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException ime) {
            System.out.println("IO exception while connecting client");
        }
    }

    public void sendMessage() {
        try {
            dos.writeUTF("Message received by the server.");
            dos.flush(); // flush ensures the message is actually sent
        } catch (IOException ime) {
            System.out.println("IO exception while sending message");
        }
    }

    public void recieveMessage() {
        try {
            String message = dis.readUTF();
            System.out.println("Client says: " + message);
            if (message.equalsIgnoreCase("quit")) {
                System.out.println("Client disconnected. Waiting for another client...");
                clientConnect(); // wait for next client
            }
        } catch (IOException ime) {
            System.out.println("IO exception while receiving message");
        }
    }

    public void quitClient() {
        try {
            clientSocket.close();
        } catch (IOException ime) {
            System.out.println("Error closing client socket");
        }
    }

    public void quitServer() {
        try {
            serverSocket.close();
        } catch (IOException ime) {
            System.out.println("Error closing server socket");
        }
    }

    public static void main(String args[]) throws IOException {
        OOPserver server = new OOPserver();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter PortNumber: ");
        int portNum = sc.nextInt();
        server.startServer(portNum);
        server.clientConnect();

        int c = 0;
        while (c < 1000) {
            server.recieveMessage();
            server.sendMessage();
            c++;
        }
        System.out.println("Limit Reached. Closing Server.....");
        server.quitServer();
        sc.close();
    }
}
