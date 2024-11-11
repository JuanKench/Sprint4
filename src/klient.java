import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class klient {


    public klient() throws IOException {

        try (Socket socketToServer = new Socket("127.0.0.1", 8888);
             PrintWriter out = new PrintWriter(socketToServer.getOutputStream(), true); // vad menas med att data fastnar i strömmen?
             BufferedReader in = new BufferedReader(new InputStreamReader(socketToServer.getInputStream()));
             BufferedReader klientIn = new BufferedReader(new InputStreamReader(System.in));
        ){
            String fromServer;
            String fromClient;

            fromServer = in.readLine();
            System.out.println(fromServer);

            while ((fromClient = klientIn.readLine()) != null) {
                out.println(fromClient);
                System.out.println("whomp" + fromClient);

                fromServer = in.readLine();
                System.out.println(fromServer);
            }

        }
    }
    public static class Main {
        public static void main(String[] args) throws IOException {
            klient k = new klient();
        }
    }
}
