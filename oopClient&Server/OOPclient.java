import java.io.*;
import java.net.*;
import java.util.Scanner;

public class OOPclient {
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    Scanner sc = new Scanner(System.in);

    public void connectToServer(String IPAddress, int portNumber){  
        try {
            socket = new Socket(IPAddress, portNumber);
            // Initialize data streams once connected
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        } catch(IOException ime){        
            System.out.println("IO exception while connecting to server");
        }
    }

    public void send(String message){
        try {
            dos.writeUTF(message);   // send UTF message
            dos.flush();             // flush to ensure it is sent
        } catch (IOException ime) {
            System.out.println("IO exception while sending message");
        }
    }

    public void recieve(){
        try {
            String response = dis.readUTF();   // receive UTF message
            System.out.println("Server says: " + response);
        } catch(IOException ime){
            System.out.println("IO exception while receiving message");
        }
    }

    public void quitClient(){
        try {
            socket.close();
        } catch (IOException ime) {
            System.out.println("Error closing socket");
        }
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        OOPclient tcp = new OOPclient();

        System.out.println("Enter IP Address: ");
        String IPAdd = sc.nextLine();
        System.out.println("Enter PortNumber: ");
        int portNum = sc.nextInt();
        tcp.connectToServer(IPAdd, portNum);
        String message;
        int c = 0;
        while (c < 1000) {
            message = sc.nextLine();
            tcp.send(message);
            if(message.equalsIgnoreCase("quit")){
                System.out.println("Quitting....");
                break;
            }
            tcp.recieve();
            c++;
        }
        sc.close();
        tcp.quitClient();
    }
}
