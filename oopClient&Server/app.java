import java.io.IOException;
import java.util.Scanner;

public class app {
    public static void main(String args[]) throws IOException {
    
        Scanner sc = new Scanner(System.in);
           OOPclient tcp10 = new OOPclient();
           System.out.println("Enter IP Address: ");
           String IPAdd = sc.nextLine();
           System.out.println("Enter PortNumber: ");
           int portNum = sc.nextInt();
           tcp10.connectToServer(IPAdd, portNum);
           String message;
           int c =0;
           while (c < 100) {
            message = sc.nextLine();
            tcp10.send(message);
            if(message.equals("quit")){
              System.out.println("Quitting....");
              break;
            }
            tcp10.recieve();
            c++;
           }
           sc.close();
           tcp10.quitClient();
  
      }
}
