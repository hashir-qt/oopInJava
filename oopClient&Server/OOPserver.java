import java.io.*;
import java.net.*;

public class OOPserver {
     ServerSocket serverSocket;
     Socket clientSocket;
     BufferedReader br;
     InputStreamReader isr;
     PrintWriter out;
     String[] Files = {"names.txt", "numbers.txt", "test.txt"};
      public void startServer(int portNumber){
          // create a server socket on port number 9090
        try {
            serverSocket = new ServerSocket(9090);
            System.out.println("Server is running and waiting for client connection...");
        } catch (IOException ime) {
             System.out.println("I0 exception");
        }

      }
      public void clientConnect(){
        try {
            clientSocket = serverSocket.accept();
           System.out.println("Client connected!");

        } catch (IOException ime) {
            System.out.println("I0 exception");
        }

      }
      public void sendMessage(){
        try{
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Message received by the server.");
        }
        catch(IOException ime){
            System.out.println("I0 exception");
        }
      }
      public void recieveMessage(){
        try{
            isr = new InputStreamReader(clientSocket.getInputStream());
            br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("Client says: " + message);
            if(message.equals("dir")){
                 sendDir();
            }
            if(message.equals("quit")){
                clientConnect();
            }
        
            
        }
       catch(IOException ime){
            System.out.println("I0 exception hhj");
       }   
      }
      public void sendDir(){
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            for(int i = 0; i < Files.length; i++){
                out.println(Files[i]);
                
            }
        } catch (Exception e) {
            
        }
      }
       public void quitClient(){
        try{
            clientSocket.close();
        }
       catch(IOException ime){}
       }
       public void quitServer(){
        try{
            serverSocket.close();
        }
       catch(IOException ime){}
       }
         
    public static void main(String args[]) throws IOException 
    {
    
        OOPserver server = new OOPserver();       
            server.startServer(9090);
            server.clientConnect();
            int c = 0;
            while (c < 100) {
                server.recieveMessage();
                server.sendMessage();
                c++;
            }
            System.out.println("Limit Reached Closing Server.....");
            server.quitServer();
        
    }
}