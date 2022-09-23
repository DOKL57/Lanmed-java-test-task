import config.Globals;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

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
        private static boolean isThreadRunning = true;
        public void run() {
            PrintWriter out = null;

            while(isThreadRunning) {
                try{
                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    String line = FileWorker.getRandomLine();
                    out.println(line);
                    Thread.sleep(Globals.SENDING_FREQUENCY * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }



            }


        }
        }

}
