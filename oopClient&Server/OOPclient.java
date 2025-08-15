import java.io.*;
import java.net.*;
import java.util.Scanner;

public class OOPclient {
    Socket socket;
    BufferedReader br;
    PrintWriter out;
    InputStreamReader isr;
    Scanner sc = new Scanner(System.in);

    public void connectToServer(String IPAddress, int portNumber){  
        try{
         socket = new Socket(IPAddress, portNumber);
           }
         catch(IOException ime){        
           }
         }

    public void send(String message){
      try {
        out = new PrintWriter(socket.getOutputStream(), true);
        out.println(message);
      } catch (IOException ime) {
      
      }
    }


    public void recieve(){
        try{
          isr = new InputStreamReader(socket.getInputStream()); 
          br = new BufferedReader(isr);
          String response = br.readLine();
          System.out.println("Server says: " + response);
          
         
        }
         catch(IOException ime){
        }
    }
     public void closeSocket(){
      try {
        socket.close();
      } catch (IOException ime) {
      }
     }
    public static void main(String args[]) throws IOException {
    
      Scanner sc = new Scanner(System.in);
         OOPclient tcp = new OOPclient();
         tcp.connectToServer("localhost", 9090);
         String message;
         int c =0;
         while (c < 100) {
          message = sc.nextLine();
          tcp.send(message);
          if(message.equals("quit")){
            System.out.println("Quitting....");
            break;
          }
          tcp.recieve();
          c++;
         }
         sc.close();
         tcp.closeSocket();

    }
}