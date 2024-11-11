import java.io.*;
import java.net.Socket;

public class klient {


    public klient() throws IOException {

        try (Socket socketToServer = new Socket("127.0.0.1", 8888);
             PrintWriter out = new PrintWriter(socketToServer.getOutputStream(), true); // vad menas med att data fastnar i strömmen?
             ObjectInputStream in = new ObjectInputStream(socketToServer.getInputStream());
             BufferedReader klientIn = new BufferedReader(new InputStreamReader(System.in));
        ){
            Object fromServer;
            String fromClient;

            fromServer = in.readObject();
            System.out.println(fromServer);

            while ((fromClient = klientIn.readLine()) != null) {
                out.println(fromClient);
                System.out.println("whomp" + fromClient);

                fromServer = in.readObject();

                if (fromServer instanceof TelefonBok) { // instanceof??
                    TelefonBok bok = (TelefonBok) fromServer; // whut is this
                    System.out.println(bok.nummer+" "+bok.namn+" "+bok.address+" "+bok.id);
                }else if(fromServer instanceof String){
                    System.out.println(fromServer);
                }


            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static class Main {
        public static void main(String[] args) throws IOException {
            klient k = new klient();
        }
    }
}
