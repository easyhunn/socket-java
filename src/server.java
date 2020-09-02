import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String args []) {
        System.out.println("server starting");
        try {
            ServerSocket ss = new ServerSocket(900);
            Socket soc = ss.accept();
            System.out.println("connection established!");
           while (true) {

               //Text

               PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
               BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
               String serverSay = serverInput.readLine();
               if (serverSay.equals("end")) {
                   out.println("server ended!");
                   break;
               }
               out.println("server say: " + serverSay);

               //received message
               BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

               String str = in.readLine();
               if (str.equals("Client end chatting")) break;
               System.out.println("client say:" + str);
           }
            soc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
