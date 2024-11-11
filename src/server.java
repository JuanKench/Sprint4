import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    dataBas d = new dataBas();


    public server() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(8888);
             Socket sock = serverSocket.accept();
             ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream())))
        {
            out.writeObject("hello letar du efter någon?");



            String temp;
            while ((temp = in.readLine()) != null) {
                TelefonBok dbAnswer = d.search(temp.trim());
                if (dbAnswer == null) {
                    out.writeObject("person not found");
                }
                out.writeObject(dbAnswer);
            }

        }

    }
    public static class Main {
        public static void main(String[] args) throws IOException {
            server k = new server();
        }
    }
}
