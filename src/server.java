import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    Protocol p = new Protocol();


    public server() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(8888);
             Socket sock = serverSocket.accept();
             PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream())))
        {
            out.println(p.getOutput(null));



            String temp;
            while ((temp = in.readLine()) != null) {
                String dbAnswer = p.getOutput(temp.trim());
                out.println(dbAnswer);
            }

        }

    }
    public static class Main {
        public static void main(String[] args) throws IOException {
            server k = new server();
        }
    }
}
