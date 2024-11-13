import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerListener {

    public ServerListener() {

        try (ServerSocket ss = new ServerSocket(8888)) {
            while (true) {
                Socket s = ss.accept();
                server ser = new server(s);
                ser.start();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ServerListener sl = new ServerListener();
    }
}
