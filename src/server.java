import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    dataBas d = new dataBas();


    public server() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(8888);
             Socket sock = serverSocket.accept();
             PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream())))
        {
            out.println("hello letar du efter någon?");



            String temp;
            while ((temp = in.readLine()) != null) {
                String dbAnswer = d.search(temp.trim());
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
