import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class klient {


    public klient() throws IOException {

        try (Socket socketToServer = new Socket("127.0.0.1", 8888);
             PrintWriter out = new PrintWriter(socketToServer.getOutputStream(), true); // vad menas med att data fastnar i strömmen?
        ){
        String mess = "womp whomp det gick bra";
        while (true){ // hur snabbt loopar en while sats/ beror hastigheten på mängden kod (antas) / finns det en bättre timer istället för sleep?
            out.println(mess);
            Thread.sleep(2000);
        }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static class Main {
        public static void main(String[] args) throws IOException {
            klient k = new klient();
        }
    }
}
