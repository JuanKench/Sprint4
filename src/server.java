import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class server extends Thread {

    Protocol p = new Protocol();

    Socket socket;

    public server(Socket socket){
        this.socket = socket;
    }
    public void run() {

            try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())))
            {
                out.println(p.getOutput(null));

                String temp;
                while ((temp = in.readLine()) != null) {
                    String dbAnswer = p.getOutput(temp.trim());
                    out.println(dbAnswer);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}

