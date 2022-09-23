package com.dokl57.taskmod;

import com.dokl57.taskmod.config.Globals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void start()
    {

        try (Socket socket = new Socket(Globals.SERVER_HOST, Globals.SERVER_PORT)) {
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            while (true) {
                if(in.readLine()!="") {
                    System.out.println("Server replied: " + in.readLine());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    }
