import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {


    public server() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(8888);
            Socket sock = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream())))
        {
            String temp;
            while ((temp = in.readLine()) != null) {
                System.out.println(temp);
            }

        }

    }
    public static class Main {
        public static void main(String[] args) throws IOException {
           server k = new server();
        }
    }
}
