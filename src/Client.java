import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) {
        System.out.println("Client starting");
        Scanner scan = new Scanner(System.in);
        try {
            Socket soc = new Socket("localhost", 900);
           while (true) {

               //Message
               // BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
               //String str = userInput.readLine();
               BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
               String serverMessage = in.readLine();
               if (serverMessage.equals("server ended!")) break;
               System.out.println(serverMessage);

               //reply


               PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

               String str = scan.nextLine();
               if (str.equals("end")) {
                    out.println("Client end chatting");
                   break;
               }
               out.println(str);
           }

            soc.close();
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
