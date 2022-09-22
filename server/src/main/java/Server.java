import config.Globals;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void start() {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(Globals.SERVER_PORT); // server is listening
            while (true){

                Socket client = serverSocket.accept(); // client object receive incoming requests
                System.out.println("Connected! " + client.getInetAddress().getHostAddress());

                ClientHandler clientHandler = new ClientHandler(client); // new thread object for client

                new Thread(clientHandler).start(); // start thread

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(serverSocket!=null){
                try{
                    serverSocket.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    private record ClientHandler(Socket clientSocket) implements Runnable {

        public void run() {

            }
        }

}
