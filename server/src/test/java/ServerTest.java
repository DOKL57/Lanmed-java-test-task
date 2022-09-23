import config.Globals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int GIVEN_FREQUENCY = Globals.SENDING_FREQUENCY;

    @BeforeAll
    synchronized static void setup(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Server.start();
            }
        }).start();
    }

    @Test
    synchronized void isServerRunning() {

                try(Socket socket = new Socket(SERVER_ADDRESS, Globals.SERVER_PORT)) {
                    assertTrue(socket.isConnected());
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }

    @Test
    synchronized void isServerSendMessage(){
                try(Socket socket = new Socket(SERVER_ADDRESS, Globals.SERVER_PORT)) {
                    BufferedReader in
                            = new BufferedReader(new InputStreamReader(
                            socket.getInputStream()));
                    assertNotEquals("",in.readLine());
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }

    @Test
    void isServerSendMessagesWithGivenFrequency(){
                try(Socket socket = new Socket(SERVER_ADDRESS, Globals.SERVER_PORT)) {
                    BufferedReader in
                            = new BufferedReader(new InputStreamReader(
                            socket.getInputStream()));
                    String recieved = in.readLine();
                    Thread.sleep(GIVEN_FREQUENCY);
                    assertEquals(recieved, in.readLine());
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

    }

}