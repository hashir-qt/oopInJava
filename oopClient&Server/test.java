
import java.io.IOException;
import java.util.Scanner;

public class test {
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
